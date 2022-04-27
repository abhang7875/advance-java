<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/style.css" rel="stylesheet">
        <script src="js/animations.js"></script>
        <title>Search Flights</title>
    </head>
    <body>       
        <div class="container" id="searchFlights" style="margin-top:5%;">
        <h1>Welcome <%= ((com.entity.User)session.getAttribute("user")).getName() %></h1>
            <h1>Search Fligts</h1>
            <h5>Fly Anywhere, Fly Everywhere</h5>
            <form method="post" action="SearchFlightsDAO">
            <div class="inputWrapper">
                <label>From: </label>
                <input id="from" type="text" class="form-control" name="from" placeholder="From">
            </div>
            <i class="fa fa-exchange" style="font-size:30px;margin-left:2%"></i>
            <div class="inputWrapper" style="float:right">
                <label>To: </label>
                <input id="to" type="text" class="form-control" name="to" placeholder="To">
            </div>
            <div class="inputWrapper">
                <label>Depart On: </label>
                <input id="departOn" type="date" class="form-control" name="depart" placeholder="Depart On">
            </div>
            <div class="inputWrapper" style="float:right">
                <label>Number of Persons: </label>
                <input id="numberofPersons" type="number" class="form-control" name="persons" placeholder="Number of Persons">
            </div>
            
            <button type="submit" class="login btn"> <i class="fa fa-search fa-fw"></i> Search Flights </button>
            </form>
        </div>
    </body>
</html>
