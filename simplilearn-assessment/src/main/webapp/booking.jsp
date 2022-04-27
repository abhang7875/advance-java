<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<% int nop = (Integer)session.getAttribute("noOfSeats"); %>
	<div class="container center">
		<h1 class="myHeading">Make Payment</h1>
		<div class="flightDetails">
			<table class="table">
                <tbody>
                    <tr class="bg-primary"><td colspan="2" style="text-align: center;font-size: 30px;"> Payment Details</td></tr>
                    <tr class="bg-success"><td>No of Seats Booked: </td><td><%= nop %></td></tr>
                    <tr class="bg-success"><td>Price per seat: </td><td>&#8377;1000</td></tr>
                    <tr class="bg-success"><td>Total: </td><td>&#8377;<%= nop*1000 %></td></tr>
                </tbody>
            </table>
            
	    <a class="btn login" href="flightDetails.jsp"><i class="fa fa-sign-in fa-fw"></i> Click Here to Make Payment</a>
		</div>
	</div>
</body>
</html>