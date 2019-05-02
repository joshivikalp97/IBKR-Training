<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pizza Hub</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
function toggle()
{
	var s=$('#searchby').val();
	$('#container').empty();
	if(s==="Phone")
		{
		$('#container').append("Enter customer Phone: <input type=\"number\" id=\"custphone\" name=\"cphone\"  maxlength=\"10\" required><br><br>");
		$('#container').append("<button type=\"submit\">Search</button>");
		}
	else if(s==="Cno")
		{$('#container').append("Enter customer ID: <input type=\"text\" name=\"cno\" id=\"custno\" required><br><br>");
		$('#container').append("<button type=\"submit\">Search</button>");
		}
		
	
	
}
</script>
</head>
<body>
<div style="text-align:center;">
<h3 style="color:red; text-align:center;">Retrieve a customer</h3>
<form id="retrieve" action="RetrieveCustServlet" method="GET">
Search customer by: <select id="searchby" name="searchby" onChange="toggle(); return false;">
<option value="">Please select an option</option>
<option value="Phone">Customer Phone number</option>
<option value="Cno">Customer ID</option>
</select><br><br>
<div id="container"></div>
</form>
</div>
</body>
</html>