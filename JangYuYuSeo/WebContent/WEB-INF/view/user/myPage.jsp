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
									<th>Name</th>
									<th>&nbsp;</th>
									<th>Address</th>
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
											<span>이름이다 </span> 
											<span>가입일 : 2021년 04월 21일</span>
										</div>
									</td>
									
									<td></td>
									
									<td>서울시 동작구 어쩌구동 </td>
									
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12">
					<h3 class="h5 mb-4 text-center">주문내역</h3>
					<div class="table-wrap">
						<table class="table">
							<thead class="thead-primary">
								<tr>
									<th>&nbsp;</th>
									<th>&nbsp;</th>
									<th>Product</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>total</th>
									<th>&nbsp;</th>
								</tr>
							</thead>
							<tbody>
								<tr class="alert" role="alert">
									<td><label class="checkbox-wrap checkbox-primary">
											<input type="checkbox" checked> <span
											class="checkmark"></span>
									</label></td>
									<td>
										<div class="img"
											style="background-image: url(${root}images02/product-1.png);"></div>
									</td>
									<td>
										<div class="email">
											<span>Sneakers Shoes 2020 For Men </span> <span>Fugiat
												voluptates quasi nemo, ipsa perferendis</span>
										</div>
									</td>
									<td>$44.99</td>
									<td class="quantity">
										<div class="input-group">
											<input type="text" name="quantity"
												class="quantity form-control input-number" value="2" min="1"
												max="100">
										</div>
									</td>
									<td>$89.98</td>
									<td>
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true"><i class="fa fa-close"></i></span>
										</button>
									</td>
								</tr>

								<tr class="alert" role="alert">
									<td><label class="checkbox-wrap checkbox-primary">
											<input type="checkbox"> <span class="checkmark"></span>
									</label></td>
									<td>
										<div class="img"
											style="background-image: url(${root}images02/product-2.png);"></div>
									</td>
									<td>
										<div class="email">
											<span>Sneakers Shoes 2020 For Men </span> <span>Fugiat
												voluptates quasi nemo, ipsa perferendis</span>
										</div>
									</td>
									<td>$30.99</td>
									<td class="quantity">
										<div class="input-group">
											<input type="text" name="quantity"
												class="quantity form-control input-number" value="1" min="1"
												max="100">
										</div>
									</td>
									<td>$30.99</td>
									<td>
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true"><i class="fa fa-close"></i></span>
										</button>
									</td>
								</tr>

								<tr class="alert" role="alert">
									<td><label class="checkbox-wrap checkbox-primary">
											<input type="checkbox"> <span class="checkmark"></span>
									</label></td>
									<td>
										<div class="img"
											style="background-image: url(${root}images02/product-3.png);"></div>
									</td>
									<td>
										<div class="email">
											<span>Sneakers Shoes 2020 For Men </span> <span>Fugiat
												voluptates quasi nemo, ipsa perferendis</span>
										</div>
									</td>
									<td>$35.50</td>
									<td class="quantity">
										<div class="input-group">
											<input type="text" name="quantity"
												class="quantity form-control input-number" value="1" min="1"
												max="100">
										</div>
									</td>
									<td>$35.50</td>
									<td>
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true"><i class="fa fa-close"></i></span>
										</button>
									</td>
								</tr>

								<tr class="alert" role="alert">
									<td><label class="checkbox-wrap checkbox-primary">
											<input type="checkbox"> <span class="checkmark"></span>
									</label></td>
									<td>
										<div class="img"
											style="background-image: url(${root}images02/product-4.png);"></div>
									</td>
									<td>
										<div class="email">
											<span>Sneakers Shoes 2020 For Men </span> <span>Fugiat
												voluptates quasi nemo, ipsa perferendis</span>
										</div>
									</td>
									<td>$76.99</td>
									<td class="quantity">
										<div class="input-group">
											<input type="text" name="quantity"
												class="quantity form-control input-number" value="1" min="1"
												max="100">
										</div>
									</td>
									<td>$76.99</td>
									<td>
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true"><i class="fa fa-close"></i></span>
										</button>
									</td>
								</tr>

								<tr class="alert" role="alert">
									<td class="border-bottom-0"><label
										class="checkbox-wrap checkbox-primary"> <input
											type="checkbox"> <span class="checkmark"></span>
									</label></td>
									<td class="border-bottom-0">
										<div class="img"
											style="background-image: url(${root}images02/product-1.png);"></div>
									</td>
									<td class="border-bottom-0">
										<div class="email">
											<span>Sneakers Shoes 2020 For Men </span> <span>Fugiat
												voluptates quasi nemo, ipsa perferendis</span>
										</div>
									</td>
									<td class="border-bottom-0">$40.00</td>
									<td class="quantity border-bottom-0">
										<div class="input-group">
											<input type="text" name="quantity"
												class="quantity form-control input-number" value="1" min="1"
												max="100">
										</div>
									</td>
									<td class="border-bottom-0">$40.00</td>
									<td class="border-bottom-0">
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true"><i class="fa fa-close"></i></span>
										</button>
									</td>
								</tr>
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