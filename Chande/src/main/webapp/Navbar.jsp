<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Website</title>
</head>
<body>
   <div class="sticky top-0 z-[9999999] flex justify-center h-[10vh] hover:bg-white transition-all duration-500">
      <div class="h-full w-[95%] flex justify-between hover:text-black items-center relative">
        <div class="text-4xl hover:text-red-600 font-extrabold cursor-pointer">Tikkit</div>
        <div
          class=""
        >
          <ul class="hidden md:flex space-x-16">
            <li class="border-expand text-md font-semibold cursor-pointer hover:text-red-800">
              <a href="/Chande/index.jsp">Home</a>
            </li>
            <li class="border-expand text-md font-semibold cursor-pointer hover:text-red-800">
              <a href="/Chande/train.jsp">Book Train</a>
            </li>
            <li class="border-expand text-md font-semibold cursor-pointer hover:text-red-800">
              <a href="/Chande/plane.jsp">Book Plane</a>
            </li>
            <li class="border-expand text-md font-semibold cursor-pointer hover:text-red-800">
              <a href="/Chande/ship.jsp">Book Ship</a>
            </li>
            <li class="border-expand text-md font-semibold cursor-pointer hover:text-red-800">
              <a href="/Chande/tickets.jsp">All Tickets</a>
            </li>
          </ul>
        </div>
        <div
          class="flex gap-8">
          <div class="flex gap-2 p-3 rounded-lg bg-red-600 items-center cursor-pointer">
            <a href="logout">Welcome,
            <%= session.getAttribute("name") %>
            </a>
        </div>
      </div>
    </div>
      </div>
</body>
</html>
