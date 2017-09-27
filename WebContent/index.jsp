<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link href="resources/css/home.css" rel="stylesheet">
<link href="resources/css/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="resources/css/swiper.min.css" rel="stylesheet">
<link href="resources/css/modal.css" rel="stylesheet">
<!-- Swiper JS -->
<script src="resources/scripts/swiper.min.js"></script>
<script src="resources/scripts/jquery-3.2.1.min.js"></script>
</head>
<body>

	<div class="headingContainer">
		<a href="/ShoppingKartNewWoM">
			<div class="logoImgDiv">
				<img class="logoImg" alt="" src="resources/images/logo.png">
			</div>
		</a>
		<div class="menuDiv">
			<ul>
				<li class="listItem"><a>Home</a></li>
				<li class="listItem"><a>About</a></li>
				<li class="listItem"><a>Contact</a></li>
			</ul>
		</div>

		<div class="userMainDiv">
			<div class="kartDiv">
				<a><i class="fa fa-shopping-cart" style="font-size: 40px"></i>kart</a>
				<p class="kartNo" id="kartValue"></p>
			</div>
			<!-- <div class="userInnerDiv">
				<div id="userDetails">
					<img class="userImg" alt="" src="resources/images/unknown_user.png">
					<label class="userName" id="userName"></label>
				</div>
				<div>
					<span class="logoutBtn"><i id="logoutBtn"
						class="fa fa-power-off"></i></span>
				</div>
			</div> -->
			<div class="userInnerDiv">
				<div id="userDetails">
					<img class="userImg" alt="" src="resources/images/unknown_user.png">
				</div>
				<div>
					<span class="userName" id="userName">User Name </span>
				</div>
				<div>
					<span class="logoutBtn"><i id="logoutBtn"
						class="fa fa-power-off"></i></span>
				</div>
			</div>
		</div>

	</div>

	<div class="mainContainer" style="margin-top: 70px;">
		<!-- Swiper -->
		<div class="swiper-container swiper-container-h"
			style="height: 300px; margin: 5px 0px;">
			<div class="swiper-wrapper">
				<div class="swiper-slide"
					style="background-image: url(resources/images/img1.jpg); background-size: cover;">
					<div class="title" data-swiper-parallax="-100">Slide 2</div>
					<div class="subtitle" data-swiper-parallax="-200">Subtitle</div>
					<div class="text" data-swiper-parallax="-300">
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Aliquam dictum mattis velit, sit amet faucibus felis iaculis nec.
							Nulla laoreet justo vitae porttitor porttitor. Suspendisse in sem
							justo. Integer laoreet magna nec elit suscipit, ac laoreet nibh
							euismod. Aliquam hendrerit lorem at elit facilisis rutrum. Ut at
							ullamcorper velit. Nulla ligula nisi, imperdiet ut lacinia nec,
							tincidunt ut libero. Aenean feugiat non eros quis feugiat.</p>
					</div>
					<!--  <img class="swiperImg" alt="" src="images/img1.jpg"> -->
				</div>
				<div class="swiper-slide">
					<img class="swiperImg" alt="" src="resources/images/img2.jpg">
				</div>
				<div class="swiper-slide">
					<img class="swiperImg" alt="" src="resources/images/img3.jpg">
				</div>
				<div class="swiper-slide">
					<img class="swiperImg" alt="" src="resources/images/img1.jpg">
				</div>
				<div class="swiper-slide">
					<img class="swiperImg" alt="" src="resources/images/img2.jpg">
				</div>
				<div class="swiper-slide">
					<img class="swiperImg" alt="" src="resources/images/img3.jpg">
				</div>
			</div>
			<!-- Add Pagination -->
			<div class="swiper-pagination swiper-pagination-h"
				style="z-index: 10"></div>
			<div class="swiper-button-next"></div>
			<div class="swiper-button-prev"></div>
		</div>

		<!-- Swiper -->
		<div class="swiper-container swiper1">
			<div class="swiper-wrapper">
				<div class="swiper-slide" style="text-align: -webkit-center;">
					<div style="width: 200px; height: 200px;">
						<img class="swiperImg1" alt=""
							src="resources/images/products/mob1.jpeg">
					</div>
					<div class="prodName">Galaxy On</div>
					<div>Price Rs: 12999/-</div>
				</div>
				<div class="swiper-slide" style="text-align: -webkit-center;">
					<a href="mobile/1000">
						<div style="width: 200px; height: 200px;">
							<img class="swiperImg1" alt=""
								src="resources/images/products/mob2.jpeg">
						</div>
						<div class="prodName">iPhone 6s Grey</div>
						<div>Price Rs: 12999/-</div>
					</a>
				</div>
				<div class="swiper-slide" style="text-align: -webkit-center;">
					<div style="width: 200px; height: 200px;">
						<img class="swiperImg1" alt=""
							src="resources/images/products/mob3.jpeg">
					</div>
					<div class="prodName">iPhone 6s Gold</div>
					<div>Price Rs: 12999/-</div>
				</div>
				<div class="swiper-slide" style="text-align: -webkit-center;">
					<div style="width: 200px; height: 200px;">
						<img class="swiperImg1" alt=""
							src="resources/images/products/mob4.jpeg">
					</div>
					<div class="prodName">Red Mi Note4</div>
					<div>Price Rs: 12999/-</div>
				</div>
				<div class="swiper-slide" style="text-align: -webkit-center;">
					<div style="width: 200px; height: 200px;">
						<img class="swiperImg1" alt=""
							src="resources/images/products/mob5.jpeg">
					</div>
					<div class="prodName">Red Mi Note4</div>
					<div>Price Rs: 12999/-</div>
				</div>
				<div class="swiper-slide" style="text-align: -webkit-center;">
					<div style="width: 200px; height: 200px;">
						<img class="swiperImg1" alt=""
							src="resources/images/products/mob6.jpeg">
					</div>
					<div class="prodName">Red Mi Note4</div>
					<div>Price Rs: 12999/-</div>
				</div>

			</div>
			<!-- Add Pagination -->
			<div class="swiper-button-next swiper-button-next1"></div>
			<div class="swiper-button-prev swiper-button-prev1"></div>
		</div>
	</div>
	<!-- <div class="modal" id="loginModal">
		<span class="modalClose" id="loginModalClose"><i
			class="fa fa-times"></i></span>
		<div class="modalContent">
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
		</div>
	</div> -->

	<div class="modal" id="loginModal">
		<div class="modalMainDiv">
			<div style="position: relative;">
				<button id="loginModalClose" class="modalClose">x</button>
				<div style="display: flex; width: 90%; height: 500px; margin: auto;">
					<div style="width: 100%; display: flex;">
						<div
							style="background-image: url('resources/images/logo-sq.png'); width: 40%; display: inline-block; padding: 50px 40px; font-size: 37px; color: white; background-position: center 85%; background-repeat: no-repeat; background-color: #2874f0;">
							<span id="modalLable">Login</span>
							<p style="font-size: 16px;" id="modalTagLine">Wel-Come to Shopping mart</p>
						</div>
						<div class="formOuterDiv">
							<div>
								<form id="modalForm">
									<div class="formInnerDiv">
										<span class="inputFieldSpan">Username:</span>
										<input id="uId" placeholder="Enter username" class="formInputField"
											type="text">
									</div>
									<div class="formInnerDiv">
										<span class="inputFieldSpan">Password:</span>
										<input id="uPass" placeholder="Enter Password" class="formInputField"
											type="text">
									</div>
									<div>
										<button class="formLoginButton" id="formLoginButton">
											<span>Login</span>
										</button>
									</div>
								</form>
							</div>
							<div style="margin-top: 16px;">
								<button class="formRegisterButton">
									<span>Register</span>
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Initialize Swiper -->
	<script>
    var swiper = new Swiper('.swiper1', {
        pagination: '.swiper-pagination',
        slidesPerView: 5,
        spaceBetween: 30,
        nextButton: '.swiper-button-next1',
        prevButton: '.swiper-button-prev1',
    });
    </script>

	<!-- Initialize Swiper -->
	<script>
    var swiperH = new Swiper('.swiper-container-h', {
    	pagination: '.swiper-pagination',
        paginationClickable: true,
        nextButton: '.swiper-button-next',
        prevButton: '.swiper-button-prev',
        autoplay: 2500,
        mousewheelControl: true,
        parallax: true
    });
    </script>
	<script>
$(function(){
		
		function displayData(){
			<%-- var name = '<%= session.getAttribute("uName") %>'; --%>
			var name ="${sessionScope.uName}";
			alert("Name = "+name);
			if(name != "null" & name.length != 0){
				<%-- var kartNo = '<%= session.getAttribute("kartNo") %>'; --%>
				$("#userName").text(name);
				$.ajax({
					url: "kartController/kartStatus",
					type: "GET",
					dataType: "json",
					data: {
						<%-- "uName" : '<%= session.getAttribute("uId") %>' --%>
						"uId" : "${sessionScope.uId}"
					},
					success: function(data){
						kartData = data;
						$("#kartValue").text(kartData.noItems).css("display","block");
						$("#loginModal").css("display","none");
						/* keys = Object.keys(kartData.product);
						for(var key in keys){
							alert(kartData.product[keys[key]]);
						} */
					}
				});
				
			}else{
				$("#userName").text("User Name"); 
			}
		}

		displayData();
		
	$("#logoutBtn").click(function(){
		$.ajax({
			url: "logout",
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

		checkloginStatus();
		
	});
	
	function checkloginStatus(){
		var name ="${sessionScope.uName}";
		if(name != "null" & name.length != 0){
			alert("User is logged in!!");
		}
		else {
			$("#loginModal").slideToggle();
		}
	};
	
	$("#loginModalClose").click(function(){
		$("#loginModal").slideToggle();
	});
	
	$("#formLoginButton").click(function(){
		$.ajax({
			url: "userLogin",
			type: "GET",
			data: {
				"uId" : $("#uId").val(),
				"uPass" : $("#uPass").val()
			},
			dataType: "json",
			success: function(data){
				alert("Status " + data);
				resData = data;
				location.reload();
			},
			error: function(data){
				alert("Login Error");
				alert(data.status + ' ' + data.statusText);
			}
		});
	});
	
});
    </script>
</body>
</html>