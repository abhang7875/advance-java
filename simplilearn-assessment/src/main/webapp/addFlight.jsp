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
    <title>Add Flight</title>
</head>
<body>
	
    <div class="container" id="registerMenu">
        <h1 class="myHeading"> Add Flight </h1>
        <div id = "error"></div>
        <form method="post" action="AddFlightDAO" id="registerForm">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-plane fa-fw"></i></span>
                <input id="airlines" type="text" class="form-control" name="airlines" placeholder="Airline">
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-fast-forward fa-fw"></i></span>
                <input id="from" type="text" class="form-control" name="from" placeholder="From" maxlength="20">
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-fast-backward fa-fw"></i></span>
                <input id="to" type="text" class="form-control" name="to" placeholder="To" maxlength="20">
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
                <input id="departOn" type="time" class="form-control" name="departOn" placeholder="Depart On">
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-calendar fa-fw"></i></span>
                <input id="arriveOn" type="time" class="form-control" name="arriveOn" placeholder="Arrive On">
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                <input id="numberOfSeats" type="number" class="form-control" name="numberOfSeats" placeholder="Number Of Seats AVailable" value="0">
            </div>
            <button type="submit" class="register btn"> <i class="fa fa-sign-in fa-fw"></i> Add </button>
        </form>
        <a class="register btn" href="index.html"> <i class="fa fa-home fa-fw"></i> Click Here to go to Home</a>
    </div>
</body>
</html>