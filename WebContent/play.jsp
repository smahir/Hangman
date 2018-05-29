<!DOCTYPE html>
<html lang="en">
<head>
<title>Play - Hangman game</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>
<%
		/*if (session.getAttribute("username") == null) {
			response.sendRedirect("index.jsp");
		}*/
	%>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-loginplay">
				<div class="login100-pic js-tilt" style="float: left;" data-tilt>
				
					<img src="images/1.png" alt="IMG">
				</div>
				<div class="tastatura" style="float: right;">
				
					
					<span class="login100-form-title"> Take a guess! <br><br>
						<p>Word to guess: 
						<%
 							if (request.getAttribute("wordHolder") != null) {
						 %>
						<%=request.getAttribute("wordHolder")%>
						<%
 							}
						 %>
						 </p>
						 <br>
						<p>Number of Mistakes: 
						<%
 							if (request.getAttribute("wrongAnswers") != null) {
						 %>
						<%= request.getAttribute("wrongAnswers") %>
						<%
 							} 
						 %>
						</p>
						<br>
						<p>Previous guesses: 
						<%
 							if (request.getAttribute("previouseGuesses") != null) {
						 %>
						<%= request.getAttribute("previouseGuesses") %>
						<%
 							} 
						 %>
						 </p>
						<br>
						<p>Score: 
						<%
 							if (request.getAttribute("score") != null) {
						 %>
						<%= request.getAttribute("score") %>
						<%
 							} 
						 %>
						 </p>
						 <br>
						<p><%
				if (request.getAttribute("error") != null) {
			%>
			<%=request.getAttribute("error")%><br />
			<%
				}
			%>
						 </p>
					</span>
				
					<form action="GameServlet" method="post">
						<input type="text" name="UserGuess" class="form-control" placeholder="Enter word or letter">
						<br>
						<button type="submit" class="btn btn-outline-secondary">Submit</button>
					</form>

				</div>
				<span class="login100-form-title"> <%
 	if (request.getAttribute("error") != null) {
 %> <%=request.getAttribute("error")%><br /> <br /> <%
 	}
 %>
				</span>

				<div class="play-navbar">
					<ul class="nav justify-content-center">
						<li class="nav-item"><a class="nav-link active"
							href="index.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="top10.jsp">Top
								10</a></li>
						<li class="nav-item">
							<form action="LogoutServlet" method="post">
								<input type="submit" value="Logout">
							</form>
						</li>
					</ul>
				</div>
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
	<script>
		$('.js-tilt').tilt({
			scale : 1.1
		})
	</script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>