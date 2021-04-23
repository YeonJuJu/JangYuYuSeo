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
  <!--===============================================================================================-->
<link rel="icon" type="image/png" href="${root}/images/icons/favicon.ico" />
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
	
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-4">
					<h2 class="heading-section">Order Form</h2>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-12"></div>
					<h3 class="h5 mb-4 text-left">Product List</h3>
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
      <br>
     <div class="row">
					<div class="container">
					  <h3 class="h5 mb-4 text-left">Order Info</h3>
            
             <div class="container-login100">
              
              <div class="m-l-40 m-r-40 container-login100">
             
                
                <div class="wrap-input100 validate-input" data-validate="Name is required">
                  <span class="label">Name</span> 
                  <input class="input100" placeholder="Enter name"/> 
                  <span class="focus-input100"></span>
                </div>
                
                <div class="wrap-input100 validate-input" data-validate="Address is required">
                  <span class="label">Address</span> 
                  <input class="input100" placeholder="Enter address"/> 
                  <span class="focus-input100"></span>
                </div>
                
                <div class="wrap-input100 validate-input" data-validate="Password is required">
                  <span class="label">Phone</span> 
                  <input class="input100" placeholder="Enter phone number"/> 
                  <span class="focus-input100"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="Password is required">
                  <span class="label">Message</span> 
                  <input class="input100" placeholder="Enter shipping message"/> 
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
	
	<script src="${root}js02/jquery.min.js"></script>
	<script src="${root}js02/popper.js"></script>
	<script src="${root}js02/bootstrap.min.js"></script>
	<script src="${root}js02/main.js"></script>
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
	
	<!-- 하단 정보 -->
	<c:import url="/WEB-INF/view/include/bottom_info.jsp" />
</body>
</html>