<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="example.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retrieval</title>
</head>
<body>
<div style="text-align:center;">
<h2>Customer retrieval</h2>
<table border=5 align=center style="text-align:center;">
<tr><th>CNO</th><th>NAME</th><th>PHONE</th><th>ADDRESS</th></tr>
<c:set var="c" value="${customer}" />
<tr>
<td><c:out value="${c.getCustNo()}" /><br></td>
<td><c:out value="${c.getCustName()}" /><br></td>
<td><c:out value="${c.getCustPhone()}" /><br></td>
<td><c:out value="${c.getCustAddr()}" /><br></td>
</tr>
</table>
<c:set var="isnull" value="${isCustNull}"/>
<c:if test="${isnull!=0}">
<p>Sorry, No such customer found!</p>
</c:if>
<a href="index.jsp" style="align:center">Home</a>
</div>
</body>
</html>
