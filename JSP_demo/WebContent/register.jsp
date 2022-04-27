<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<form action="" method="">
		Name: <input type="text" name="name"><br>
		Email: <input type="text" name="email"><br>
		Password: <input type="text" name="pass"><br>
		Age : <input type="number" name="age"><br> 
		Gender: <input type="radio" value="Male" name="male"> Male
		 <input type="radio" value="Female" name="female"> Female<br>
		  <input type="submit" value="Register" name="register">

	</form>
	<%
	if (request.getParameter("register") != null) {
	%>
	<jsp:useBean id="user" class="com.to.User" scope="request"></jsp:useBean>
	<jsp:setProperty property="*" name="user" />
	<jsp:forward page="RegisterServlet"></jsp:forward>
	<%
	}
	%>>
</body>
</html>