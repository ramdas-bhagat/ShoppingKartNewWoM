<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="../scripts/jquery-3.2.1.min.js"></script>
<link href="../css/home.css" rel="stylesheet">
<link href="../css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="../css/swiper.min.css" rel="stylesheet">
<link href="../css/prodView.css" rel="stylesheet">
<!-- Swiper JS -->
<script src="../scripts/swiper.min.js"></script>
</head>
<body>
	<div class="headingContainer">
		<a href="/"><div class="logoImgDiv"><img class="logoImg" alt="" src="../images/logo.png"></div></a>
		<div class="menuDiv">
			<ul>
				<li class="listItem"><a>Home</a></li>
				<li class="listItem"><a>About</a></li>
				<li class="listItem"><a>Contact</a></li>
			</ul>
		</div>
		
		<div class="userMainDiv">
			<div class="kartDiv">
				<a><i class="fa fa-shopping-cart" style="font-size: 40px"></i></a>
			</div>
			<div class="userInnerDiv">
				<img class="userImg" alt="" src="../images/unknown_user.png">
				<label class="userName" id="userName" isLoggedIn="false">User Name</label>
			</div>
		</div>
	</div>
	<div class="loginMainDiv" id="loginForm">
		<div class="loginInputDiv">
			<label class="loginLabel">User Name: </label><input class="loginInput" type="text" id="uName" name="uName" placeholder="Enter User Name">
		</div>
		<div>
			<label class="loginLabel">Password: </label><input class="loginInput"type="text" id="uPass" name="uPass" placeholder="Enter Password">
		</div>
		<input type="button" value="Login" id="uLogin" class="loginButton">
	</div>	
	<p>Product Id: ${productId}</p>
	<p>Product Brand: ${make}</p>
	<p>Product Name: </p>${name}
	<p>Product Image: </p><img alt="" src="../images/products/${image}">
	<p>Product Price: </p>${price }
	<p>Availability: ${availability}</p>
	<input type="button" value="Add To Cart" id="addToKart" class="loginButton">
	
	<script type="text/javascript">
		$("#addToKart").on("click", function(){
			var status = $("#userName").attr("isLoggedIn");
			if(status == "true")
				alert("User is logged in!!");
			else {
				
				alert("user isn't logged in!!");
				$("#loginForm").css("display","flex");
			}
		});
		$("#uLogin").click(function(){
			$.ajax({
				url: "../userLogin.htm",
				type: "GET",
				data: {
					"uName" : $("#uName").val(),
					"uPass" : $("#uPass").val()
				},
				dataType: "json",
				success: function(data){
					alert("Status " + data);
				},
				error: function(data){
					alert("Error");
				}
			});
		});
	</script>
</body>
</html>