<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	
	<link href="../resources/css/home.css" rel="stylesheet">
	<link href="../resources/css/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	<link href="../resources/css/swiper.min.css" rel="stylesheet">
	<link href="../resources/css/prodView.css" rel="stylesheet">

	<script src="../resources/scripts/jquery-3.2.1.min.js"></script>
	<!-- Swiper JS -->
	<script src="../resources/scripts/swiper.min.js"></script>
</head>
<body>
	<div class="headingContainer">
		<a href="/ShoppingKartNewWoM">
		<div class="logoImgDiv"><img class="logoImg" alt="" src="../resources/images/logo.png"></div></a>
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
				<p class="kartNo" id="kartValue"></p>
			</div>
			<div class="userInnerDiv" id="userDetails">
					<img class="userImg" alt="" src="../resources/images/unknown_user.png">
					<label class="userName" id="userName"></label>
					<span class="logoutBtn"><i id="logoutBtn" class="fa fa-power-off"></i></span>
			</div>
		</div>
		<div class="loginMainDiv" id="loginForm">
			<div class="loginInputDiv">
				<label class="loginLabel">User Name: </label><input class="loginInput" type="text" id="uName" name="uName" placeholder="Enter User Name">
			</div>
			<div class="loginInputDiv">
				<label class="loginLabel">Password: </label><input class="loginInput"type="text" id="uPass" name="uPass" placeholder="Enter Password">
			</div>
			<input type="button" value="Login" id="uLogin" class="loginButton">
		</div>
		
	</div>
		
	<div style="margin-top: 120px;">
		<p>Product Id: </p><p id="productId">${productId}</p>
		<p>Product Brand: ${make}</p>
		<p>Product Name: </p>${name}
		<p>Product Image: </p><img alt="" src="../resources/images/products/${image}">
		<p>Product Price: </p>${price }
		<p>Availability: ${availability}</p>
		<input type="button" value="Add To Cart" id="addToKart" class="loginButton">
	</div>
	<input type="text" name="uID" id="uID" value="${sessionScope.productId}" />
	<h1>session</h1>
	<script>
	window.k = '<%= session.getAttribute("productId") %>';
	</script>
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
	<h1>${kartItems} </h1>
	<script type="text/javascript">
	$(function(){
		
		function displayData(){
			<%-- var name = '<%= session.getAttribute("uName") %>'; --%>
			var name ="${sessionScope.uName}";
			if(name != "null" & name.length != 0){
				<%-- var kartNo = '<%= session.getAttribute("kartNo") %>'; --%>
				$("#userName").text(name);
				$.ajax({
					url: "../kartController/kartStatus",
					type: "GET",
					dataType: "json",
					data: {
						<%-- "uName" : '<%= session.getAttribute("uId") %>' --%>
						"uId" : "${sessionScope.uId}"
					},
					success: function(data){
						kartData = data;
						$("#kartValue").text(kartData.noItems).css("display","block");
						$("#loginForm").css("display","none");
						keys = Object.keys(kartData.product);
						for(var key in keys){
							alert(kartData.product[keys[key]]);
						}
					}
				});
				
			}else{
				$("#userName").text("User Name"); 
			}
		}
		<%-- <% 
			if(session.getAttribute("uName") != null){
				String uname="Hello World"; 
				session.setAttribute("sessname",uname); 
			}else{
				String uname="Please Login"; 
				session.setAttribute("sessname",uname); 
			}
		%> 
		var name1 = '<%= session.getAttribute("sessname") %>';
		alert("session obj "+ name1);
		--%> 
		
		displayData();
		
	$("#logoutBtn").click(function(){
		$.ajax({
			url: "../logout",
			type: "GET",
			dataType: "json",
			success: function(data){
				alert(data);
				location.reload();
			},
			error: function(){
				alert("Error");
			}
		});
	})
	$("#userDetails").click(function(){
		<%-- var name = '<%= session.getAttribute("uName") %>'; --%>
		/* $.ajax({
			url: "../checkLogin.htm",
			type: "GET",
			dataTypr: "json",
			success: function(data){
				if(data != "\"Logged out\""){
					alert("Status logged in");
				}else{
					alert("Status logged out");
				}
			}
		}); */
		checkloginStatus();
		
	});
	
	function checkloginStatus(){
		<%-- var name = '<%= session.getAttribute("uName") %>'; --%>
		var name ="${sessionScope.uName}";
		if(name != "null" & name.length != 0){
			alert("User is logged in!!");
		}
		else {
			
			//alert("user isn't logged in!!");
			//$("#loginForm").css("display","block");
			$("#loginForm").slideToggle();
		}
	}
		$("#addToKart").on("click", function(){
			/* checkloginStatus(); */
			<%-- var name = '<%= session.getAttribute("uName") %>'; --%>
			var name ="${sessionScope.uName}";
			if(name != "null" & name.length != 0){
				alert("User is logged in!!");
				addToKart();
			}
			else {
				
				//alert("user isn't logged in!!");
				//$("#loginForm").css("display","block");
				$("#loginForm").slideToggle();
				$("#uLogin").click(function(){
					$.ajaxSetup({async: false});
					$.ajax({
						url: "../userLogin",
						type: "GET",
						data: {
							"uName" : $("#uName").val(),
							"uPass" : $("#uPass").val()
						},
						dataType: "json",
						success: function(data){
							alert("Status " + data);
							resData = data;
							addToKart();
						},
						error: function(data){
							alert("Error");
						}
					});
					$.ajaxSetup({async: true});
				});
			}
		});
		function addToKart(){
			$.ajax({
				url: "../kartController/addToKart",
				type: "GET",
				dataType: "json",
				data: {
					productId: $("#productId").text(),
					<%-- userID: '<%= session.getAttribute("uId") %>' --%>
					userID: "${sessionScope.uId}"
				},
				success: function(data){
					alert(data);
					location.reload();
				},
				error: function(){
					alert("Error");
				}
			});
		}
		
		$("#uLogin").click(function(){
			$.ajax({
				url: "../userLogin",
				type: "GET",
				data: {
					"uName" : $("#uName").val(),
					"uPass" : $("#uPass").val()
				},
				dataType: "json",
				success: function(data){
					alert("Status " + data);
					resData = data;
					location.reload();
				},
				error: function(data){
					alert("Error");
				}
			});
		});
	});
	</script>
</body>
</html>