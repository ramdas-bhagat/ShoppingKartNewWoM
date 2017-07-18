$(function() {

	function displayData() {
		/*var name = "${sessionScope.uName}";*/
		var name = $.session.get('uName');
		if (name != "null" & name.length != 0) {
			$("#userName").text(name);
			$.ajax({
				url : "../kartController/kartStatus.htm",
				type : "GET",
				dataType : "json",
				data : {
					/*"uName" : "${sessionScope.uId}"*/
					"uName" :	$.session.get('uId')
				},
				success : function(data) {
					kartData = data;
					$("#kartValue").text(kartData.noItems).css("display",
							"block");
					$("#loginForm").css("display", "none");
				}
			});

		} else {
			$("#userName").text("User Name");
		}
	}

	displayData();

	$("#logoutBtn").click(function() {
		$.ajax({
			url : "../logout.htm",
			type : "GET",
			dataType : "json",
			success : function(data) {
				alert(data);
				location.reload();
			},
			error : function() {
				alert("Error");
			}
		});
	})
	$("#userDetails").click(function() {
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

	function checkloginStatus() {
		/*var name = "${sessionScope.uName}";*/
		var name = $.session.get('uName');
		if (name != "null" & name.length != 0) {
			alert("User is logged in!!");
		} else {
			//alert("user isn't logged in!!");
			//$("#loginForm").css("display","block");
			$("#loginForm").slideToggle();
		}
	}
	$("#addToKart").on("click", function() {
		/* checkloginStatus(); */
		/*var name = "${sessionScope.uName}";*/
		var name = $.session.get('uName');
		if (name != "null" & name.length != 0) {
			alert("User is logged in!!");
			addToKart();
		} else {

			//alert("user isn't logged in!!");
			//$("#loginForm").css("display","block");
			$("#loginForm").slideToggle();
			$("#uLogin").click(function() {
				$.ajaxSetup({
					async : false
				});
				$.ajax({
					url : "../userLogin.htm",
					type : "GET",
					data : {
						"uName" : $("#uName").val(),
						"uPass" : $("#uPass").val()
					},
					dataType : "json",
					success : function(data) {
						alert("Status " + data);
						resData = data;
						addToKart();
					},
					error : function(data) {
						alert("Error");
					}
				});
				$.ajaxSetup({
					async : true
				});
			});
		}
	});
	function addToKart() {
		$.ajax({
			url : "../kartController/addToKart.htm",
			type : "GET",
			dataType : "json",
			data : {
				productId : $("#productId").text(),
				/*userID : "${sessionScope.uId}"*/
				userID : $.session.get('uId')
			},
			success : function(data) {
				alert(data);
				location.reload();
			},
			error : function() {
				alert("Error");
			}
		});
	}

	$("#uLogin").click(function() {
		$.ajax({
			url : "../userLogin.htm",
			type : "GET",
			data : {
				"uName" : $("#uName").val(),
				"uPass" : $("#uPass").val()
			},
			dataType : "json",
			success : function(data) {
				alert("Status " + data);
				resData = data;
				location.reload();
			},
			error : function(data) {
				alert("Error");
			}
		});
	});
});