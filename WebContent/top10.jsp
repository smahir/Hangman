<!DOCTYPE html>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List" buffer="8kb" isELIgnored="false"
	session="true" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isThreadSafe="true" isErrorPage="false"
	%>
	
	<!-- taglib directive -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	


<html lang="en">
<head>
	<title>Top 10 - Hangman game</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100-top10">
				
				<span class="login100-top10">
					Top 10 leaderboard 
				</span>


				<table class="table">
					<thead>
					  <tr>
						<th scope="col">#</th>
						<th scope="col">Username</th>
						<th scope="col">Score</th>
						<th scope="col">Game ID</th>
					  </tr>
					</thead>
					<tbody>
					
					</tbody>
					<c:forEach items="${gameList}" var="game" varStatus="counter">

					<tr>
						<td>${counter.count}</td>
						<td>${game.userID}</td>
						<td>${game.score}</td>
						<td>${game.id}</td>


						

					</tr>
					</c:forEach>
					</tbody>
				</table>
				  
				<button type="button" class="btn btn-outline-secondary">
					<a href="index.jsp">Home</a>
				</button>
				<button type="button" class="btn btn-outline-secondary">
					<a href="play.jsp">Play</a>
				</button>

			</div>
		</div>
	</div>
	
	

	
<!--===============================================================================================-->	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/tilt/tilt.jquery.min.js"></script>
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>