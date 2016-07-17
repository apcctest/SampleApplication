<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Continuous delivery and Integration - Demo</title>
<link href='http://fonts.googleapis.com/css?family=Lato:400,700'
	rel='stylesheet' type='text/css'>

<style type="text/css">
body {
	background: #1a78c2;
	font-family: 'Lato', sans-serif;
	color: #FDFCFB;
	text-align: center;
}

form {
	width: 950px;
	margin: 12% auto;
}

.header {
	font-size: 30px;
	text-transform: uppercase;
	letter-spacing: 5px;
}

.description {
	font-size: 20px;
	letter-spacing: 1px;
	line-height: 1.3em;
	margin: -2px 0 25px;
	text-align: center;
}

.button {
	height: 44px;
	border: none;
	width: 25%;
	height: 46px;
	background: #79c0f7;
	font-family: inherit;
	font-weight: bold;
	color: inherit;
	letter-spacing: 1px;
	border-radius: 5px 5px 5px 5px;
	cursor: pointer;
	transition: background .3s ease-in-out;
}

.button:hover {
	background: #d45d7d;
}
</style>
</head>
<body>
	<form action="UserController" method="post" name="welcomeformaction">

		<div class="description">
			<p>This is a New application sample application developed to show a demo on user
				management. The application is developed in JAVA and it uses
				Postgres database to store the user details. Try it now with latest code</p>
		</div>
		<div class="header">
			<p>Manage your Account</p>
		</div>

		<div class="input">
			<input type="submit" name="signup" class="button" id="signup" value="SIGN UP" onclick="javascript:document.getElementById('action').value = 'signup';">
			&nbsp;&nbsp; 
			<input type="submit" name="login" class="button" id="login" value="LOGIN" onclick="javascript:document.getElementById('action').value = 'login';">
			
			<input type="hidden" name="action" id="action" value="">
		</div>
	</form>
</body>
</html>