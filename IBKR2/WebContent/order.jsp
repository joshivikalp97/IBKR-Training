<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="example.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<script type="text/javascript">
function showConfirm(value)
{
	var ans=confirm("Previous customer with name "+value+ " found with same phone details. Press OK to continue and cancel to go back and edit! ");
	if(ans===false)
		{
			window.location="orderPage.jsp";
		}
	else{}
}
</script>
</head>
</body>
<h3>
<c:set var="c" value="${cust}" />
Customer Number: <c:out value="${c.getCustNo()}" /><br>
Customer Name: <c:out value="${c.getCustName()}" /><br>
Customer Phone:  <c:out value="${c.getCustPhone()}" /><br>
Customer Address:  <c:out value="${c.getCustAddr()}" /><br>
</h3>
<div style="text-align:center; align:center;">
<h3>YOUR ORDER</h3><br><br>
<table style="text-align:center;" align="center" border="5px">;
<tr><th>PIZZA     </th><th>     COST</th><tr>
 
 <c:forEach items="${pizz}" var="p">
	 <tr>
	 <td>${p.quantity} ${p.size} ${p.type} ${p.variant} ${p.name}</td>
	 <td>${p.costOfPizza}</td>
	 </tr>
 </c:forEach>
 <c:set var="b" value="${bill}" />
 <tr>
 <td><strong>TOTAL</strong></td>
 <td><c:out value="${b.total}" /></td>
 </tr>
</table>
</div>
<br><br>Data successfully inserted in the databse!
<a href="index.jsp" style="align:center">Home</a>
</body>
</html>
<%
Customer c=(Customer)request.getAttribute("cust");
Bill b=(Bill)request.getAttribute("bill");
if((Integer)request.getAttribute("isPrev")==1)
{
	out.println("<script>showConfirm(\""+c.getCustName()+"\");</script>");
}
CustomerReport.SaveCust(c);
BillReport.SaveBill(b, c);

%>