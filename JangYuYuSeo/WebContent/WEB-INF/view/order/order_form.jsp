<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 절대경로 설정 -->
<c:url var="root" value="/" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JangYuYuSeo</title>
    
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="${root}resources/css02/style.css">
    <!--===============================================================================================-->
	<link rel="icon" type="image/png" href="${root}resources//images/icons/favicon.ico" />
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${root}resources/vendor/bootstrap/css/bootstrap.min.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${root}resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${root}resources/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${root}resources/vendor/animate/animate.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${root}resources/vendor/css-hamburgers/hamburgers.min.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${root}resources/vendor/animsition/css/animsition.min.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${root}resources/vendor/select2/select2.min.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${root}resources/vendor/daterangepicker/daterangepicker.css">
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${root}resources/css/util.css">
	<link rel="stylesheet" type="text/css" href="${root}resources/css/main.css?after">
	<!--===============================================================================================-->
</head>
<body>
    <!-- 상단 메뉴 -->
	<c:import url="/WEB-INF/view/include/top_menu.jsp" />
	<c:import url="/WEB-INF/view/include/category_menu.jsp" />

	<form:form action="${root }order/order_proc" method="post" ModelAttribute="orderDTO">
		<section class="ftco-section">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-6 text-center mb-4">
						<h2 class="heading-section">Order Form</h2>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-12">
						<h3 class="h5 mb-4 text-left">Product List</h3>
					
						<div class="table-wrap">
							<table class="table">
								<thead class="thead-primary">
									<tr>
										<th style="font-weight: bold; font-size: 1em">&nbsp;</th>
										<th style="font-weight: bold; font-size: 1em">Product</th>
										<th style="font-weight: bold; font-size: 1em">Price</th>
										<th style="font-weight: bold; font-size: 1em">Quantity</th>
										<th style="font-weight: bold; font-size: 1em">total</th>
									</tr>
								</thead>
								<tbody>
		
									<c:forEach var="product" items="${cartProductList}">
										<tr class="alert" role="alert">
											<td>
												<div class="img" style="background-image: url(${pageContext.request.contextPath}/${product.pr_image}); width:60px; height:60px;"></div>
											</td>
											
											<td>
												<div class="product">
													<div>${product.pr_name }</div>
													<medium class="text-muted">${product.pr_size}&nbsp;&nbsp;${product.pr_color}</medium>
												</div>
											</td>
											
											<td>₩<fmt:formatNumber value="${product.pr_price}" pattern="#,###,###" />
												<div id='price' style="display: none">${product.pr_price}</div>
											</td>
											
											<td class="quantity">
												<div id='count'>${product.pr_amount}</div>
											</td>
											
											<td id='total'>₩<fmt:formatNumber
													value="${product.total_price}" pattern="#,###,###" />
											</td>
										</tr>
									</c:forEach>
									<tr class="alert" role="alert">
									<td>&nbsp;&nbsp;총 금액</td>
									<td></td>
									<td></td>
									<td></td>
									<td>
									₩<fmt:formatNumber value="${total}" pattern="#,###,###" />
									</td> 
								</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			
			<br>
			
			<div class="row">
				<div class="container">
					<h3 class="h5 mb-4 text-left">Order Info</h3>
	
					<div class="container-login100">
	
						<div class="m-l-40 m-r-40 container-login100">
	
	
							<div class="wrap-input100 validate-input"
								data-validate="Name is required">
								<span class="label">Name</span> 
								<input name="order_name" class="input100" value="${userInfo.user_name}" /> 
								<span class="focus-input100"></span>
							</div>
	
							<div class="wrap-input100 validate-input"
								data-validate="Address is required">
								<span class="label">Address</span> 
								<input name="order_address" class="input100" value="${userInfo.user_address}" /> 
									<span class="focus-input100"></span>
							</div>
	
							<div class="wrap-input100 validate-input"
								data-validate="Password is required">
								<span class="label">Phone</span> 
								<input name="order_phone" class="input100" value="${userInfo.user_phone}" /> 
								<span class="focus-input100"></span>
							</div>
	
							<div class="wrap-input100 validate-input"
								data-validate="Password is required">
								<span class="label">Message</span> 
								<input name="order_message" class="input100" placeholder="Enter shopping message" /> 
								<span class="focus-input100"></span>
							</div>
	
	
							<div class="container-login100-form-btn">
								<button class="login100-form-btn" style="margin: auto;">주문하기</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</form:form>
	
	<script src="${root}resources/js02/jquery.min.js"></script>
	<script src="${root}resources/js02/popper.js"></script>
	<script src="${root}resources/js02/bootstrap.min.js"></script>
	<script src="${root}resources/js02/main.js"></script>
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
	
	<!-- 하단 정보 -->
	<c:import url="/WEB-INF/view/include/bottom_info.jsp" />
</body>
</html>