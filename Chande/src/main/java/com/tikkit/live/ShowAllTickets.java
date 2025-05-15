package com.tikkit.live;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ShowAllTickets")
public class ShowAllTickets extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "All Tickets";

        Connection con = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ticket_db?useSSL=false", "root", "");

        	PreparedStatement pst = con.prepareStatement("SELECT * FROM tickets");
        	ResultSet rs = pst.executeQuery();

        	out.println("<html><head><title>" + title + "</title>");
        	out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css\"></head><body class=\"bg-gray-100\">");
        	out.println("<div class=\"max-w-4xl mx-auto p-8 bg-white shadow-lg mt-8 rounded\">");
        	out.println("<h2 class=\"text-2xl font-semibold mb-4\">All Tickets</h2>");
        	out.println("<table class=\"table-auto w-full border-collapse border border-gray-800\">");
        	out.println("<thead><tr>");
        	out.println("<th class=\"py-2 px-4 border-b\">Username</th>");
        	out.println("<th class=\"py-2 px-4 border-b\">Ticket Type</th>");
        	out.println("<th class=\"py-2 px-4 border-b\">Starting Point</th>");
        	out.println("<th class=\"py-2 px-4 border-b\">Ending Point</th>");
        	out.println("<th class=\"py-2 px-4 border-b\">Travel Date</th>");
        	out.println("</tr></thead>");
        	out.println("<tbody id=\"ticketTable\" class=\"divide-y divide-gray-800\">");

        	while (rs.next()) {
        	    out.println("<tr>");
        	    out.println("<td class=\"py-2 px-4\">" + rs.getString("username") + "</td>");
        	    out.println("<td class=\"py-2 px-4\">" + rs.getString("ticket_type") + "</td>");
        	    out.println("<td class=\"py-2 px-4\">" + rs.getString("starting_point") + "</td>");
        	    out.println("<td class=\"py-2 px-4\">" + rs.getString("ending_point") + "</td>");
        	    out.println("<td class=\"py-2 px-4\">" + rs.getString("travel_date") + "</td>");
        	    out.println("</tr>");
        	}

        	out.println("</tbody></table></div></body></html>");

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
