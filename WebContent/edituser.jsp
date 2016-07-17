<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Continuous delivery and Integration - Edit</title>
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
	width: 1000px;
	margin: 12% auto;
	border: thin outset lightgrey;
	padding: 10px 0px 40px 0px;
}

#tablesignup {
	width: 1000px;
	border-collapse: collapse;
}

#tablesignup td {
	padding: 10px;
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

.error {
	font-size: 20px;
	color: #ef7861;
	letter-spacing: 1px;
	line-height: 1.3em;
	margin: -2px 0 25px;
	text-align: center;
}

.input {
	align-items: center;
}

.textbox {
	height: 44px;
	border: none;
	width: 50%;
	height: 35px;
	background: #ECF0F1;
	font-weight: bold;
	font-size: 20px;
	border-radius: 5px 5px 5px 5px;
	transition: background .3s ease-in-out;
	text-align: left;
	padding: 5px;
}

.halftab {
	font-size: 15pt;
	width: 37%;
}

.button {
	height: 35px;
	border: none;
	width: 50%;
	background: #79c0f7;
	font-family: inherit;
	font-weight: bold;
	color: inherit;
	letter-spacing: 5px;
	border-radius: 5px 5px 5px 5px;
	transition: background .3s ease-in-out;
}

.button:hover {
	background: #E86C8D;
}

input:focus {
	outline: none;
	outline: 2px solid #E86C8D;
	box-shadow: 0 0 2px #E86C8D;
}
</style>
</head>
<body>
	<form action="UserController" method="post" name="signup">
		<div class="error">
			<h2>${message}</h2>
		</div>
		<div class="header">
			<ins>
				<p>Edit user details</p>
			</ins>
		</div>

		<div class="input">
			<table id="tablesignup">
				<tr>
					<td class="halftab">First name :</td>
					<td> <input type="text" name="firstname" id="firstnameid" value="${user.firstName}"
						class="textbox"></td>
				</tr>
				<tr>
					<td class="halftab">Last name :</td>
					<td><input type="text" name="lastname" value="${user.lastname}" class="textbox">
					</td>
				</tr>
				<tr>
					<td class="halftab">Username :</td>
					<td><input type="text" name="username" value="${user.userName}" class="textbox" readonly="readonly" >
					</td>
				</tr>
				<tr>
					<td class="halftab">Password :</td>
					<td><input type="password" name="password" class="textbox">
					</td>
				</tr>
				<tr>
					<td class="halftab">Email Address :</td>
					<td><input type="text" name="emailid" id="email" value="${user.emailAddress}"
						class="textbox"></td>
				</tr>
			</table>
			<br><br>
			<div>
				<input type="submit" name="submit" value="Update" class="button">
				<input type="hidden" name="action" id="action" value="updateuserdetails">
			</div>
		</div>
	</form>
</body>
</html>