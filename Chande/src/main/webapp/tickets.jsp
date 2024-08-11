<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <meta charset="ISO-8859-1">
    <title>Tickets</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">

    <%@ include file="Navbar.jsp" %>

    <div class="container mx-auto my-8">
        <table class="table-auto w-full border-collapse border" id="ticketTable">
  
            <tbody>
            </tbody>
        </table>
    </div>

    <script>
        $(document).ready(function () {
            // Make an AJAX request to the servlet
            $.ajax({
                url: 'ShowAllTickets',
                type: 'GET',
                dataType: 'html',
                success: function (data) {
                    // Update the table body with the received data
                    $('#ticketTable tbody').html(data);
                },
                error: function (error) {
                    console.log('Error:', error);
                }
            });
        });
    </script>
</body>
</html>
