<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JangYuYuSeo</title>
    
    <!-- Bootstrap CDN -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>

<body>

	<!-- 상단 메뉴 -->
	<c:import url="/WEB-INF/view/include/top_menu.jsp"/>
	<c:import url="/WEB-INF/view/include/category_menu.jsp"/>
    
    <!-- 메인 게시판 부분 -->
    <div class="album py-5 bg-light" style="margin-top:130px">
        <div class="container">
        <h1>Best!</h1>
          <div class="row">
          </div>
        </div>
           <div class="container">
            <c:forEach var="product" items="${bestProductList}">
            	<div class="col-md-4" style="display:inline-block">
        			<div class="card mb-4 box-shadow">
          				<a href="${root}product/display?product_id=${product.pr_id}">
             				<img class="card-img-top" style="height: 225px; width: 100%; display: block;" src="${pageContext.request.contextPath}/${product.pr_image}" data-holder-rendered="true">
          				</a>
          				<div class="card-body">
            				<h3>${product.pr_name}</h3> 
            				<p class="card-text">${product.pr_description}</p>
            				<p class="card-text"><fmt:formatNumber value="${product.pr_price}" pattern="#,###,###"/> ₩</p>
            				<div class="d-flex justify-content-between align-items-center">
              				<small class="text-muted">${product.pr_size}&nbsp;&nbsp;${product.pr_color}</small>
            				</div>
          				</div>
        			</div>
      			</div>
      		</c:forEach>
          </div>
        </div>
        <div class="container">
        <h1>"New!"</h1>
          <div class="row">
          </div>
        </div>
           <div class="container">
            <c:forEach var="product" items="${newProductList}">
            	<div class="col-md-4" style="display:inline-block">
        			<div class="card mb-4 box-shadow">
          				<a href="${root}product/display?product_id=${product.pr_id}">
             				<img class="card-img-top" style="height: 225px; width: 100%; display: block;" src="${pageContext.request.contextPath}/${product.pr_image}" data-holder-rendered="true">
          				</a>
          				<div class="card-body">
            				<h3>${product.pr_name}</h3> 
            				<p class="card-text">${product.pr_description}</p>
            				<p class="card-text"><fmt:formatNumber value="${product.pr_price}" pattern="#,###,###"/> ₩</p>
            				<div class="d-flex justify-content-between align-items-center">
              				<small class="text-muted">${product.pr_size}&nbsp;&nbsp;${product.pr_color}</small>
            				</div>
          				</div>
        			</div>
      			</div>
      		</c:forEach>
          </div>
        </div>
      </div>
      
     <!-- 하단 정보 -->
     <c:import url="/WEB-INF/view/include/bottom_info.jsp"/>
</body>

</html>