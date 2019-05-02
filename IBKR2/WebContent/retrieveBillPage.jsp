<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pizza Hub</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div style="text-align:center;">
<h3 style="color:red; text-align:center;">Retrieve a Bill</h3>
<form id="retrieve" action="RetrieveBillServlet" method="GET">
<div id="container">
Enter Bill ID: <input type="text" name="bno" id="bno" required><br><br>
<button type="submit">Search</button>
</div>
</form>
</div>
</body>
</html>