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
    
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="${root}css02/style.css">
</head>
<body>
    <!-- 상단 메뉴 -->
	<c:import url="/WEB-INF/view/include/top_menu.jsp" />
	<c:import url="/WEB-INF/view/include/category_menu.jsp" />
	
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-4">
					<h2 class="heading-section">My Page</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h3 class="h5 mb-4 text-left">Profile</h3>
					<div class="table-wrap">
						<table class="table">
							<thead class="thead-primary">
								<tr>
									<th>&nbsp;</th>
									<th>&nbsp;</th>
									<th style="font-weight:bold; font-size:1em">Name</th>
									<th>&nbsp;</th>
									<th style="font-weight:bold; font-size:1em">Address</th>
									<th>&nbsp;</th>
									<th>&nbsp;</th>
								</tr>
							</thead>
							<tbody>
								<tr class="alert" role="alert">
									<td>
										<label class="checkbox-wrap checkbox-primary">
											<input type="checkbox" checked> 
											<span class="checkmark"></span>
										</label>
									</td>
									
									<td>
										<div class="img" style="background-image: url(${root}images02/profile.png);"></div>
									</td>
									
									<td>
										<div class="email">
											<span style="font-weight:bold; font-size:1em">${loginUserDTO.user_name } </span> 
											<span style="font-weight:bold">가입일 : ${loginUserDTO.user_signupdate }</span>
										</div>
									</td>
									
									<td></td>
									
									<td style="font-weight:bold">${loginUserDTO.user_address } </td>
									
									<td>
										<a href="${root}user/before_modify" style="font-weight:bold; font-size:1em">edit</a>
									</td>
									
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			
			<br>
			
			<div class="row">
				<div class="col-md-12">
					<h3 class="h5 mb-4 text-left">Order-List</h3>
					<div class="table-wrap">
						<table class="table">
							<thead class="thead-primary">
								<tr>
									<th>&nbsp;</th>
									<th>&nbsp;</th>
									<th style="font-weight:bold; font-size:1em">Product</th>
									<th style="font-weight:bold; font-size:1em">Price</th>
									<th style="font-weight:bold; font-size:1em">Date</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="orderDTO" items="${orderDTOList}">
									<tr class="alert" role="alert">
										<td>
											<label class="checkbox-wrap checkbox-primary">
												<input type="checkbox" checked> 
												<span class="checkmark"></span>
											</label>
										</td>
										
										<td>
											<div class="img"
												style="background-image: url(${root}images02/cart.png); width:60px; height:60px;"></div>
										</td>
										
										<td>
											<div class="email">
												<span>Sneakers </span> 
												<span>Fugia</span>
											</div>
										</td>
										
										<td>$44.99</td>
										
										<td>${orderDTO.order_date}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<script src="${root}js02/jquery.min.js"></script>
	<script src="${root}js02/popper.js"></script>
	<script src="${root}js02/bootstrap.min.js"></script>
	<script src="${root}js02/main.js"></script>
	
	<!-- 하단 정보 -->
	<c:import url="/WEB-INF/view/include/bottom_info.jsp" />
</body>
</html>