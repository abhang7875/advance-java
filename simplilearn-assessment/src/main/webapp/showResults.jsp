<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="java.util.*"%>
<%@page import="com.entity.Flight"%>

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
    <title>Flights</title>
</head>
<body>
<% List<Flight> data = (List<Flight>)session.getAttribute("data");%>
<% if(data.size()==0){%>
	<h1>No Results Found..!!</h1>
<% } else {%>
    <form method="post" action="RedirectDAO">
	<table class="table table-striped" style="margin-top:3%">
        <thead>
        <tr>
            <th scope="col">AirLines</th>
            <th scope="col">From</th>
            <th scope="col">To</th>
            <th scope="col">Depart On</th>
            <th scope="col">Arrive On</th>
            <th scope="col">Action</th>
         </tr>
        </thead>
        <tbody>
        <% for(int i=0;i<data.size();i++){ %>
            <tr>
            	<input type="hidden" name="id" value="<%= data.get(i).getId()%>">
                <td><%= data.get(i).getAirlines()%></td>
                <td><%= data.get(i).getFrom()%></td>
                <td><%= data.get(i).getTo()%></td>
                <td><%= data.get(i).getDepartOn()%></td>
                <td><%= data.get(i).getArriveOn()%></td>
                <td><button class='btn btn-warning' type="submit">Book</button></td>
            </tr>
<% }} %>
</tbody></table></form>
</body>
</html>