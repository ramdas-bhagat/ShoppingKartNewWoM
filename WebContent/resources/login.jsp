<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="modal" id="loginModal">
		<span class="modalClose" id="loginModalClose"><i class="fa fa-times"></i></span>
		<!-- <div class="modalContent"> -->
		<div class="loginMainDiv" id="loginForm">
			<div class="modalImageDiv">
				<img alt="LoginForm Image"
					src="resources/images/loginformDemoImage.jpg" style="width: 100%;">
			</div>
			<div class="loginFormDiv">
				<div class="loginInputDiv">
					<label class="loginLabel">User Name: </label> <input
						class="loginInput" type="text" id="uId" name="uId"
						placeholder="Enter User Name">
				</div>
				<div class="loginInputDiv">
					<label class="loginLabel">Password: </label><input
						class="loginInput" type="text" id="uPass" name="uPass"
						placeholder="Enter Password">
				</div>
				<input type="button" value="Login" id="uLogin" class="loginButton">
				<p id="registerNewUser" class="registerBtn">Register</p>
			</div>
		</div>
		<!-- </div> -->
	</div>
</body>
</html>