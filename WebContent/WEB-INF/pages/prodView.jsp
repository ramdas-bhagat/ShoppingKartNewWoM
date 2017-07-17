<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	
	<link href="../css/home.css" rel="stylesheet">
	<link href="../css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	<link href="../css/swiper.min.css" rel="stylesheet">
	<link href="../css/prodView.css" rel="stylesheet">

	<script src="../scripts/jquery-3.2.1.min.js"></script>
	<!-- Swiper JS -->
	<script src="../scripts/swiper.min.js"></script>
</head>
<body>
	<div class="headingContainer">
		<a href="/ShoppingKartNewWoM"><div class="logoImgDiv"><img class="logoImg" alt="" src="../images/logo.png"></div></a>
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
				<label class="kartNo" id="kartValue">${kartItems}</label>
			</div>
			<div class="userInnerDiv" id="userDetails">
					<img class="userImg" alt="" src="../images/unknown_user.png">
					<label class="userName" id="userName" isLoggedIn="false"><%= session.getAttribute("uName") %></label>
			</div>
		</div>
	</div>
	<div class="loginMainDiv" id="loginForm" style="margin-top: 85px;">
		<div class="loginInputDiv">
			<label class="loginLabel">User Name: </label><input class="loginInput" type="text" id="uName" name="uName" placeholder="Enter User Name">
		</div>
		<div>
			<label class="loginLabel">Password: </label><input class="loginInput"type="text" id="uPass" name="uPass" placeholder="Enter Password">
		</div>
		<input type="button" value="Login" id="uLogin" class="loginButton">
	</div>	
	<div style="margin-top: 120px;">
		<p>Product Id: ${productId}</p>
		<p>Product Brand: ${make}</p>
		<p>Product Name: </p>${name}
		<p>Product Image: </p><img alt="" src="../images/products/${image}">
		<p>Product Price: </p>${price }
		<p>Availability: ${availability}</p>
		<input type="button" value="Add To Cart" id="addToKart" class="loginButton">
	</div>
	<input type="text" name="pONumb" value="${sessionScope.uName}" />
	<%= session.getAttribute("uId") %>
	<%-- <%
		String userName = null;
		Cookie[] cookies = request.getCookies();
		if(cookies !=null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("shopLogin")) userName = cookie.getValue();
		}
		}
	%>
	<h1><%=userName %></h1> --%>
	
	<script type="text/javascript">
	$(function(){
		var name = '<%= session.getAttribute("uName") %>';
		alert("session obj "+ name);
		$("#userName").text(name); 
	});
		
	$("#userDetails").click(function(){
		var name = '<%= session.getAttribute("uName") %>';
		if(name != null && name.length != 0){
			alert("Status logged in");
		}else{
			alert("Status logged out");
		}
	});
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
					resData = data;
					$("#loginForm").css("display","none");
					$("#userName").attr("isLoggedIn", "true");
					/* $("#userName").text(resData.userName); */
					<%-- $("#userName").html('<%= session.getAttribute("uName") %>'); --%>
					var kartNo = $("#kartValue").val();
					alert("kart no "+ kartNo);
					kartNo = kartNo + 1;
					$("#kartValue").text(kartNo);
					$("#kartValue").css("display","flex");
					addToKart();
				},
				error: function(data){
					alert("Error");
				}
			});
		});
		
		function addToKart(){
			
		}
	</script>
</body>
</html>