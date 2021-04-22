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
<link rel="icon" type="image/png" href="${root}images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${root}vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${root}fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${root}fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${root}vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${root}vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${root}vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${root}vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="${root}vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="${root}css/util.css">
<link rel="stylesheet" type="text/css" href="${root}css/main.css?after">
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
					style="background-image: url(${root}images/bg-02.jpg);">
					<span class="login100-form-title-1">상품수정</span>
				</div>
				<form:form action="${root }product/modify?product_id=${productDTO.pr_id}" method="post" modelAttribute="productDTO" class="login100-form validate-form" enctype="multipart/form-data">
					<div class="wrap-input100 validate-input m-b-26">
						<span class="label-input100">상품이름</span> 
						<form:input path="pr_name" class="input100" placeholder="상품이름 입력" value = "${productDTO.pr_name}"/> 
						<span class="focus-input100"></span>
						<form:errors path="pr_name" style="color:red;" />
					</div>
					
					<div class="wrap-input100 validate-input m-b-26">
						<span class="label-input100">카테고리</span>
						<form:select path="pr_category" >
							<c:forEach var="category" items="${categoryList}" begin="2">
    							<option value=${category.category_idx} ${category.category_idx == productDTO.pr_category ? 'selected="selected"':''} >${category.category_name}</option>
							</c:forEach>
  						</form:select>
					</div>
					
					
					
					<div class="wrap-input100 validate-input m-b-26">
						<span class="label-input100">대표 이미지</span>
						<input type="file" id="gdsImg" name="file" />
						<br></br>
					</div>
						

					<div class="wrap-input100 validate-input m-b-26">
						<span class="label-input100">상품 가격</span>
						<form:input path="pr_price" class="input100" placeholder="상품가격 입력" value = "${productDTO.pr_price}"/>
						<span class="focus-input100"></span>
						<form:errors path="pr_price" style="color:red;" />
					</div>
					
					<div class="wrap-input100 validate-input m-b-26">
						<span class="label-input100">상품설명</span> 
						<form:input path="pr_description" class="input100" placeholder="상품설명 입력" value = "${productDTO.pr_description}"/>
						<span class="focus-input100"></span>
						<form:errors path="pr_description" style="color:red;" />
							
					</div>
					
					<div class="wrap-input100 validate-input m-b-26"">
						<span class="label-input100">사이즈</span>
						<form:input path="pr_size" class="input100" placeholder="상품사이즈 입력(,로 구분하여 입력)"  value = "${productDTO.pr_size}"/>
						<span class="focus-input100"></span>
						<form:errors path="pr_size" style="color:red;" />
					</div>
					
					<div class="wrap-input100 validate-input m-b-26">
						<span class="label-input100">색상</span> 
						<form:input path="pr_color" class="input100" placeholder="상품색상 입력(,로 구분하여 입력)"  value = "${productDTO.pr_color}"/>
						<span class="focus-input100"></span>
						<form:errors path="pr_color" style="color:red;" />
					</div>
					
					<div class="wrap-input100 validate-input m-b-26">
						<span class="label-input100">재고</span>
						<form:input path="pr_stock" class="input100" placeholder="상품재고 입력"  value = "${productDTO.pr_stock}"/>
						<span class="focus-input100"></span>
						<form:errors path="pr_stock" style="color:red;" />
					</div>

					<div class="wrap-input100 validate-input m-b-26">
						<span class="label-input100">상세설명</span> 
						<form:input path="pr_detail" class="input100" placeholder="상품 상세설명 입력"  value = "${productDTO.pr_detail}"/>
						<span class="focus-input100"></span>
						<form:errors path="pr_detail" style="color:red;" />
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn">수정</button>
					</div>
					
					</form:form>
				</form>
			</div>
		</div>
	</div>

	<!--===============================================================================================-->
	<script src="${root}vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="${root}vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="${root}vendor/bootstrap/js/popper.js"></script>
	<script src="${root}vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="${root}vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="${root}vendor/daterangepicker/moment.min.js"></script>
	<script src="${root}vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="${root}vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>




	<c:import url="/WEB-INF/view/include/bottom_info.jsp" />
</body>
</html>