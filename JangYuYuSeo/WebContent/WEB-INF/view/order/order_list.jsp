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

		<section class="ftco-section">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-6 text-center mb-4">
						<h2 class="heading-section">Order List</h2>
					</div>
				</div>
			<div class="row">
				<div class="col-md-12">
					<h3 class="h5 mb-4 text-left">Order-List</h3>
					<div class="table-wrap">
						<table class="table">
								<thead class="thead-primary">
									<tr>
										<th style="font-weight: bold; font-size: 1em">&nbsp;</th>
										<th style="font-weight: bold; font-size: 1em">Name</th>
										<th style="font-weight: bold; font-size: 1em">Address</th>
										<th style="font-weight: bold; font-size: 1em">Phone</th>
										<th style="font-weight: bold; font-size: 1em">Message</th>
										<th style="font-weight: bold; font-size: 1em">Date</th>
									</tr>
								</thead>
								<tbody>
		
									<c:forEach var="order" items="${orderList}">
										<tr>
										<td><div class="clickable" style="cursor:pointer" data-toggle="collapse" data-target="#accordion${order.order_id}" > > </div></td>
										<td>${order.order_name}</td>
										<td>${order.order_address}</td>
										<td>${order.order_phone}</td>
										<td>${order.order_message}</td>
										<td>${order.order_date}</td>
										</tr>
										<c:forEach var="product" items="${productList}">
											<c:if test="${product.order_id eq order.order_id}">
												<tr class="collapse" id="accordion${product.order_id}">
													<td style="background-color: rgb(248,249,253)"></td>
													<td style="background-color: rgb(248,249,253)">${product.pr_name}</td>
													<td style="background-color: rgb(248,249,253)">${product.pr_color}</td>
													<td style="background-color: rgb(248,249,253)">${product.pr_size}</td>
													<td style="background-color: rgb(248,249,253)">${product.pr_amount}</td>
													<td style="background-color: rgb(248,249,253)">₩<fmt:formatNumber value="${product.pr_total_price}" pattern="#,###,###" /></td>
												</tr>
											</c:if>
										</c:forEach>
									</c:forEach>
									
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</section>
	
	<script src="${root}resources/js02/jquery.min.js"></script>
	<script src="${root}resources/js02/popper.js"></script>
	<script src="${root}resources/js02/bootstrap.min.js"></script>
	<script src="${root}resources/js02/main.js"></script>

	<!-- 하단 정보 -->
	<c:import url="/WEB-INF/view/include/bottom_info.jsp" />
</body>
</html>