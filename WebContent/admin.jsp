<!DOCTYPE html>
<html lang="en">
<head>
<title>Admin - Hangman game</title>
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
		if (session.getAttribute("username") == "Mahir");
		{

		}
	%>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100-top10">

				<span class="login100-top10"> Add words </span>
				<div class="form">
				<form action="AddWordServlet" method="post">
					<div class="form-group">
						<label for="exampleFormControlInput1">Word</label> <input
							type="word" name="word" class="form-control" id="exampleFormControlInput1"
							placeholder="Minimum 5 letters">
					</div>
					<div class="form-group">
						<label for="exampleFormControlSelect1">Category</label> <select
							class="form-control" id="exampleFormControlSelect1" name="category_id">
							<option>1</option>
							<option>3</option>
							<option>5</option>
						</select>
					</div>
					<div class="form-group">
					<button class="btn btn-primary" type="submit">Submit</button>
					</div>
				</form>
				</div>
				<div class="row">
				<button type="button" class="btn btn-outline-secondary">
					<a href="index.jsp">Home</a>
				</button>
				<button type="button" class="btn btn-outline-secondary">
					<a href="play.jsp">Play</a>
				</button>
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