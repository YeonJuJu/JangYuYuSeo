<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<!-- Bootstrap CDN -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>

<body>

	<!-- 상단 메뉴 -->
	<c:import url="/WEB-INF/view/include/top_menu.jsp" />
	<c:import url="/WEB-INF/view/include/category_menu.jsp" />

	<!-- 메인 게시판 부분 -->
	<div class="album py-5 bg-light" style="margin-top: 130px">
		<div class="container">
			<div class="row"></div>
		</div>
		<div class="container">
			<div class="col-12">
				<div class="card mb-4 box-shadow">
					<div class="row no-gutters">
						<div class="col-4">
							<img class="card-img-top"
								style="height: 300px; width: 100%; display: block;"
								src="${pageContext.request.contextPath}/${productDTO.pr_image}"
								data-holder-rendered="true">
						</div>
						<div class="col-8">
							<div class="card-body" style="margin-left: 10px">
								<h3>${productDTO.pr_name}</h3>
								<p class="card-text">${productDTO.pr_description}</p>
								<p class="card-text">
									<fmt:formatNumber value="${productDTO.pr_price}"
										pattern="#,###,###" />
									₩
								</p>
								<div class="text-muted">
									Color&nbsp; <select name="color">
										<c:forEach var="color" items="${colorList}">
											<option value=${color}>${color}</option>
										</c:forEach>
									</select>
								</div>

								<div class="text-muted">
									Size&nbsp; <select name="size">
										<c:forEach var="size" items="${sizeList}">
											<option value=${size}>${size}</option>
										</c:forEach>
									</select>
								</div>

								<br></br>
								<div>
									<button class="login100-form-btn"  onclick = "location.href = '${root}order/cart'"" >장바구니</button>
									<button class="login100-form-btn"  onclick = "location.href = '${root}order/orderform'" />주문하기</button>
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="container">
				<h5>${productDTO.pr_detail}</h5>
			</div>

		</div>

	</div>


	<!-- 하단 정보 -->
	<c:import url="/WEB-INF/view/include/bottom_info.jsp" />
</body>

</html>
