package com.tikkit.live;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *  implementation class BookTicketServlet
 */
@WebServlet("/booktrainticket")
public class BookTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String ticket_type = request.getParameter("ticket_type");
		String starting_point = request.getParameter("starting_point");
		String ending_point= request.getParameter("ending_point");
		String travel_date =request.getParameter("travel_date");
		RequestDispatcher dispatcher = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ticket_db", "root", "");
			PreparedStatement pst = con.prepareStatement("insert into tickets(username,ticket_type,starting_point,ending_point,travel_date) values(?,?,?,?,?)");
			pst.setString(1, username);
			pst.setString(2, ticket_type);
			pst.setString(3, starting_point);
			pst.setString(4, ending_point);
			pst.setString(5, travel_date);

			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("tickets.jsp");

			if (rowCount > 0) {

				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "failed");
			}

			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
