<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.IOException"%>
<%@ page import = "java.util.List"%>

<%@ page import = "javax.persistence.Query"%>
<%@ page import = "javax.servlet.ServletException"%>
<%@ page import = "javax.servlet.annotation.WebServlet"%>
<%@ page import = "javax.servlet.http.HttpServlet"%>
<%@ page import = "javax.servlet.http.HttpServletRequest"%>
<%@ page import = "javax.servlet.http.HttpServletResponse"%>

<%@ page import = "org.hibernate.Session"%>
<%@ page import = "org.hibernate.SessionFactory"%>
<%@ page import = "org.hibernate.Transaction"%>
<%@ page import = "org.hibernate.boot.registry.StandardServiceRegistryBuilder"%>
<%@ page import = "org.hibernate.cfg.Configuration"%>

<%@ page import = "com.entity.Flight"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="css/style.css" rel="stylesheet">
    <script src="js/animations.js"></script>
</head>
<body>
<%
	Configuration configuration = new Configuration().configure();
	configuration.addAnnotatedClass(com.entity.Flight.class);
	StandardServiceRegistryBuilder ssr = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	SessionFactory factory = configuration.buildSessionFactory(ssr.build());
	int id = Integer.parseInt((String) session.getAttribute("flightID"));
	Session s = factory.openSession();
	Transaction t = s.beginTransaction();
	Flight flight = s.get(com.entity.Flight.class,id);
	t.commit();
%>
<% int nop = (Integer)session.getAttribute("noOfSeats"); %>
	<div class="container center">
		<h1 class="myHeading">Your Flight Details</h1>
		<div class="flightDetails">
			<table class="table">
                <tbody>
                    <tr class="bg-primary"><td colspan="2" style="text-align: center;font-size: 30px;"> Flight Details</td></tr>
                    <tr class="bg-success"><td>Airlines: </td><td><%= flight.getAirlines() %></td></tr>
                    <tr class="bg-success"><td>From: </td><td><%= flight.getFrom() %></td></tr>
                    <tr class="bg-success"><td>To: </td><td><%= flight.getTo() %></td></tr>
                    <tr class="bg-success"><td>Depart on: </td><td><%= flight.getDepartOn() %></td></tr>
                    <tr class="bg-success"><td>Arrive on: </td><td><%= flight.getArriveOn() %></td></tr>
                    <tr class="bg-success"><td>No of Seats Booked: </td><td><%= nop %></td></tr>
                    <tr class="bg-success"><td>Total: </td><td>&#8377;<%= nop*1000 %></td></tr>
                </tbody>
            </table>
            
	    <a class="btn login" href="index.html"><i class="fa fa-home fa-fw"></i> Click Here to go to Home</a>
		</div>
	</div>
</body>
</html>