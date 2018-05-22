<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>H+ Sport</title>

</head>
<body>
	
	<section id="login" class="section">
		<div class="container tagline">
			<%
				if (request.getAttribute("error") != null) {
			%>
			<%=request.getAttribute("error")%><br />
			<%
				}
			%>
			<em>LOGIN USER</em>
			<form action="login" method="post">
				<label>Username</label> <input type="text" name="username"
					id="username"><br />
				<label>Password</label> <input type="password" name="password" id="password"><br /> 
				<input 	type="submit" value="Login">
			</form>
		</div>
	</section>
	<!-- #products -->



	
</body>
</html>