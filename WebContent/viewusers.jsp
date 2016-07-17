<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Continuous delivery and Integration - Demo Application</title>
<link href='http://fonts.googleapis.com/css?family=Lato:400,700'
	rel='stylesheet' type='text/css'>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	border:thin outset lightgrey;
	padding: 10px 0px 40px 0px;
}

#tablesignup {
	width: 1000px;
	border-spacing: 5px;
	
}

#tablesignup th {
	font: bold;
	border:thin solid lightslategrey;
		
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
}

.halftab {
	font-size: 15pt;
	width: 37%;
}

.button {
	height: 25px;
	border: 1px;
	width: 56px;
	padding:2px;
	background: #79c0f7;
	font-family: inherit;
	font-weight: bold;
	color: inherit;
	padding: 0px 2px 0px 0px;
	border-radius: 5px 5px 5px 5px;
	transition: background .3s ease-in-out;
}

input:focus {
	outline: none;
	outline: 2px solid #E86C8D;
	box-shadow: 0 0 2px #E86C8D;
}
</style>
</head>
<body>
	<form action="UserController" method="post" name="viewusers">
		<div class="header">
			<ins>
				<p>List of users</p>
			</ins>
		</div>

		<div class="input">
			<table id="tablesignup" >
				<tr height="10px">
					<th>User Name</th>
					<th>Email Address</th>
					<th>Joined Date</th>
					<th>Edit</th>
					<th>Remove</th>
				</tr>
				<c:forEach items="${userlist}" var="user" >
				<tr>
					<td>${user.userName}</td>
					<td>${user.emailAddress}</td>
					<td>${user.joinedDate}</td>
					
					<td><input type="submit" name="edit" id="editId" value="Edit" 
							onmouseover="this.style.background='#143b14';" 
							onmouseout="this.style.background='#79c0f7';" 
							onclick="document.getElementById('action').value='edituser'; 
									 document.getElementById('usernametoworkonid').value='${user.userName}';" class="button"></td>
							
					<td><input type="submit" name="remove" id="removeId" value="Remove"
							onmouseover="this.style.background='#ee2c2c';" 
							onmouseout="this.style.background='#79c0f7';" 
							onclick="document.getElementById('action').value='removeuser'; 
							document.getElementById('usernametoworkonid').value='${user.userName}';" class="button">
							</td> 
				</tr>
				</c:forEach>
			</table>
		</div>
		<input type="hidden" name="action" id="action" value="">
		<input type="hidden" name="usernametoworkon" id="usernametoworkonid" value="">
	</form>
</body>
</html>