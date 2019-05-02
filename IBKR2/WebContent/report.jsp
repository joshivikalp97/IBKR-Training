<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="example.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div style="text-align:center;">
<h2>TODAY'S SALES REPORT</h2><br><br>
<c:set var="s" value="${sales}" />
<c:set var="isnull" value="${isSaleNull}" />
<c:if test="${isnull!=0}">
<p>Sorry! No report is available for today's date.</p>
</c:if>
<c:if test="${isnull==0}">
<strong>FOR DATE</strong> : <c:out value="${s.getDt()}" /><br><br>
Total Bills so far : <c:out value="${s.getBillCount()}" /><br><br>
Total sale : <c:out value="${s.getSalesToday()}" /><br><br>
Total Veg pizzas sold : <c:out value="${s.getVegSold()}" /><br><br>
Total Non-Veg pizzas sold : <c:out value="${s.getNonVegSold()}" /><br><br>
Total Italian pizzas sold : <c:out value="${s.getItalianSold()}" /><br><br>
Total Mexican pizzas sold : <c:out value="${s.getMexicanSold()}" /><br><br>
</c:if>
<a href="index.jsp" style="align:center">Home</a>
</div>