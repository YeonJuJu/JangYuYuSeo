<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- 절대경로 설정 -->
<c:url var="root" value="/" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JangYuYuSeo</title>
    
    <!-- Bootstrap CDN -->
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="${root}resources/images/icons/favicon.ico" />
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css"
		href="${root}resources/vendor/bootstrap/css/bootstrap.min.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css"
		href="${root}resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css"
		href="${root}resources/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css"
		href="${root}resources/vendor/animate/animate.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css"
		href="${root}resources/vendor/css-hamburgers/hamburgers.min.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css"
		href="${root}resources/vendor/animsition/css/animsition.min.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css"
		href="${root}resources/vendor/select2/select2.min.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css"
		href="${root}resources/vendor/daterangepicker/daterangepicker.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${root}resources/css/util.css">
	<link rel="stylesheet" type="text/css" href="${root}resources/css/main.css?after">
	<!--===============================================================================================-->
</head>
<body>
    <!-- 상단 메뉴 -->
	<c:import url="/WEB-INF/view/include/top_menu.jsp" />
	<c:import url="/WEB-INF/view/include/category_menu.jsp" />
	
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-form-title"
					style="background-image: url(${root}resources/images/bg-02.jpg);">
					<span class="login100-form-title-1"> Modify Information </span>
				</div>

				<form:form action="${root }user/modify_proc" method="post" modelAttribute="modifyUserDTO" class="login100-form validate-form">
					<div class="wrap-input100 validate-input m-b-26" data-validate="Username is required">
						<span class="label-input100">ID</span> 
						<form:input path="user_id" class="input100" readonly="true"/> 
						<span class="focus-input100"></span>
						<form:errors path="user_id" style="color:red;" />
					</div>
					
					<div class="wrap-input100 validate-input m-b-18" data-validate="Password is required">
						<span class="label-input100">Password</span> 
						<form:input path="user_password" class="input100"/> 
						<span class="focus-input100"></span>
						<form:errors path="user_password" style="color:red;" />
					</div>
					
					<div class="wrap-input100 validate-input m-b-18" data-validate="Name is required">
						<span class="label-input100">Name</span> 
						<form:input path="user_name" class="input100"/> 
						<span class="focus-input100"></span>
						<form:errors path="user_name" style="color:red;" />
					</div>
					
					<div class="wrap-input100 validate-input m-b-18" data-validate="Address is required">
						<span class="label-input100">Address</span> 
						<form:input path="user_address" class="input100"/> 
						<span class="focus-input100"></span>
						<form:errors path="user_address" style="color:red;" />
					</div>
					
					<div class="wrap-input100 validate-input m-b-18" data-validate="Password is required">
						<span class="label-input100">Phone</span> 
						<form:input path="user_phone" class="input100"/> 
						<span class="focus-input100"></span>
						<form:errors path="user_phone" style="color:red;" />
					</div>

					<div class="container-login100-form-btn">
						<form:button class="login100-form-btn">Update</form:button>
					</div>
				</form:form>
				
			</div>
		</div>
	</div>

	<!--===============================================================================================-->
	<script src="${root}resources/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="${root}resources/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="${root}resources/vendor/bootstrap/js/popper.js"></script>
	<script src="${root}resources/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="${root}resources/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="${root}resources/vendor/daterangepicker/moment.min.js"></script>
	<script src="${root}resources/vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="${root}resources/vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>




	<c:import url="/WEB-INF/view/include/bottom_info.jsp" />

</body>
</html>