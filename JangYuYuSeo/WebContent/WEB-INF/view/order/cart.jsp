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
	<link rel="stylesheet" href="${root}css02/style.css">
	<script type="text/javascript">
			
			function update_amount(id){
				 const result = document.getElementById("count"+id.toString());
				  // 현재 화면에 표시된 값
		 		let number = result.value;
		 		if(number>100){ 
					alert("최대 구매 수량은 100개 입니다."); 
					return; 
				} else if(number<1){ 
					alert("수량은 1개 이상 입력해 주십시오."); 
					return; 
				} 
				var form = document.createElement('form');
				form.setAttribute('method', 'post');
				form.setAttribute('action', "/JangYuYuSeo/cart/update_amount?cart_product_id="+id+"&amount="+number);
				document.charset = "utf-8";
				document.body.appendChild(form);
				form.submit();
				alert("수량이 변경되었습니다."); 
			}

			function change_qty2(type,id){ 
				// element	
			  const result = document.getElementById("count"+id.toString());
			  const total = document.getElementById("total"+id.toString());		
			  const price = document.getElementById("price"+id.toString());
			  // 현재 화면에 표시된 값
	 		 let number = result.value;
	  
			  // 더하기/빼기
			  if(type === 'plus') {
			    number = parseInt(number) + 1;
			    if(number>100){ 
					alert("최대 구매 수량은 100개 입니다."); 
					return; 
				} 
	    
			  }else if(type === 'minus')  {
			    number = parseInt(number) - 1;
			    if(number<1){ 
					alert("수량은 1개 이상 입력해 주십시오."); 
					return; 

			    }

	  		}
	  		// 결과 출력
	  		result.value = number;
	  		total.innerText = (number*price.innerText).toLocaleString( 'ko-KR', { style: 'currency', currency: 'KRW' } );
		}
	
	</script>
</head>
<body>
    <!-- 상단 메뉴 -->
	<c:import url="/WEB-INF/view/include/top_menu.jsp" />
	<c:import url="/WEB-INF/view/include/category_menu.jsp" />
	
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-4">
					<h2 class="heading-section">Cart</h2>
				</div>
			</div>		
		
			<div class="row">
				<div class="col-md-12">
					<div class="table-wrap">
						<table class="table">
							<thead class="thead-primary">
								<tr>
									<th>&nbsp;</th>
									<th>&nbsp;</th>
									<th style="font-weight:bold; font-size:1em">Product</th>
									<th style="font-weight:bold; font-size:1em">Price</th>
									<th style="font-weight:bold; font-size:1em">Quantity</th>
									<th style="font-weight:bold; font-size:1em">total</th>
								</tr>
							</thead>
							<tbody>
							
							<c:forEach var="product" items="${cartProductList}">
								<tr class="alert" role="alert">
									<td><label class="checkbox-wrap checkbox-primary">
											<input type="checkbox" checked> <span
											class="checkmark"></span>
									</label></td>
									<td>
										<div class="img"
											style="background-image: url(${pageContext.request.contextPath}/${product.pr_image});"></div>
									</td>
									<td>
									<a href="${root}product/display?product_id=${product.pr_id}">
										<div class="product">
											<div>${product.pr_name }</div>
 											<medium class="text-muted">${product.pr_size}&nbsp;&nbsp;${product.pr_color}</medium>
										</div>
										
									</a>
									</td>
									<td>
										₩<fmt:formatNumber value="${product.pr_price}" pattern="#,###,###" />
										<div id='price${product.cart_pr_id}' style="display:none">${product.pr_price}</div>
									</td>
									<td class="quantity">
										<input value="-" type="button" onclick='change_qty2("minus","${product.cart_pr_id}")'>
										<input id='count${product.cart_pr_id}' type="text" value = "${product.pr_amount}"> 
										<input value="+" type="button" onClick ='change_qty2("plus","${product.cart_pr_id}")'>
										<input value="변경" type="button" onClick ='update_amount("${product.cart_pr_id}")'>
									</td>
									<td id='total${product.cart_pr_id}'>
									₩<fmt:formatNumber value="${product.total_price}" pattern="#,###,###" />
									</td> 
									<td class="border-bottom-0">
										<button type="button" class="close" onClick="location.href='${root }cart/cartProductDelete?cart_product_id=${product.cart_pr_id}'">
											<span aria-hidden="true"><i class="fa fa-close"></i></span>
										</button>
									</td>
								</tr>


							</c:forEach>
							</tbody>
						</table>
					</div>
					<br>
					<div>
					<a href="${root}cart/orderform">
						<button style="background:#99b19c; color:#fff; border:none; padding:0 2em; cursor:pointer; float:right;">Order</button>
					</a>
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