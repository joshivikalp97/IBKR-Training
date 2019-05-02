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
function addField(){

var count=$('#count').val();
count++;
$('#count').attr("value",count);


var form=$('#container');
form.append("<strong>Pizza"+count+"</strong><br>")
form.append("Type : <select id=\"type"+count+"\" name=\"type"+count+"\"></select>");
var type=$('#type'+count);
type.append("<option value=\"Veg\">Veg</option>");
type.append("<option value=\"Non-Veg\">Non-Veg</option>");
form.append("<br><br>");

form.append("Variant: <select id=\"variant"+count+"\" name=\"variant"+count+"\"></select>");
var variant=$('#variant'+count);
variant.append("<option value=\"Italian\">Italian</option>");
variant.append("<option value=\"Italian\">Mexican</option>");
form.append("<br><br>");

form.append("Name: <select id=\"name"+count+"\" name=\"name"+count+"\"></select>");
var nam=$('#name'+count);
nam.append("<option value=\"Margherita\">Margherita</option>");
nam.append("<option value=\"Extravaganza\">Extravaganza</option>");
form.append("<br><br>");

form.append("Size: <select id=\"size"+count+"\" name=\"size"+count+"\"></select>");
var size=$('#size'+count);
size.append("<option value=\"Regular\">Regular</option>");
size.append("<option value=\"Medium\">Medium</option>");
size.append("<option value=\"Large\">Large</option>");
form.append("<br><br>");

form.append("Topping: <select id=\"topping"+count+"\" name=\"topping"+count+"\"></select>");
var top=$('#topping'+count);
top.append("<option value=\"None\">None</option>");
top.append("<option value=\"Cheese\">Cheese</option>");
top.append("<option value=\"Onion\">Onion</option>");
form.append("<br><br>");

form.append("Quantity: <input type=\"text\" id=\"quantity"+count+"\" name=\"quantity"+count+"\" required> <br><br>");

}
</script>
</head>
<body>
<div style="text-align:center;">
<h3 style="color:red; text-align:center;">Place an order</h3>
<form id="order" action="OrderServlet" method="GET">

Enter customer name: <input type="text" name="custname" required><br><br>
Enter customer Phone: <input type="number" id="custphone" name="custphone" maxlength="15" required><br><br>
Enter customer address: <input type="text" name="custadd" required><br><br>
<p>NOTE: If phone number matches with any previous customer, their details will be used</p>
<input id="count" name="count" type="hidden" value=0>

<div id="container" >
</div>

<button onclick="addField(); return false;">Add a pizza</button><br><br>

<button type="submit">Place order</button>
</form>
</div>
</body>
</html>