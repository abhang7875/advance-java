<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello</title>
</head>
<body>
	<h1>Hello From HTML</h1>
	<%="<h1>Hello From JSP</h1>"%>
	<%
	int x = 2;
	%>
	<form action="">
	<input type="number" name="mynumber"><br>
	<input type="submit" name="click" value="Click me">
	</form>
	<%
	if(request.getParameter("click") != null){
		x = Integer.parseInt(request.getParameter("mynumber"));
	}
	%>
	<%
	for(int i=1;i<=10;i++)
		out.print(x+" * "+i+" = "+(x*i)+"<br>");
	%>
	The current date is <%= new Date()%>
	<br><br>
	<%@include file="footer.html" %>
	<%-- JSP Implicit objects
	out - JSPWriter
	application - ServletContext
	config - ServletConfig
	page - object
	pageContext - PageContext
	Exception- Throwable
	request - HttpServletRequest
	response - HttpServletResponse
	 --%>
</body>
</html>