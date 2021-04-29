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
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
    <link rel="stylesheet" href="${root}summernote/css/summernote-lite.css">
    
    <script src="${root}summernote/js/summernote-lite.js"></script>
	<script src="${root}summernote/js/lang/summernote-ko-KR.js"></script>
	
	<link rel="icon" type="image/png" href="${root}images/icons/favicon.ico" />
	<link rel="stylesheet" type="text/css" href="${root}vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${root}fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="${root}fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="${root}vendor/animate/animate.css">
	<link rel="stylesheet" type="text/css" href="${root}vendor/css-hamburgers/hamburgers.min.css">
	<link rel="stylesheet" type="text/css" href="${root}vendor/animsition/css/animsition.min.css">
	<link rel="stylesheet" type="text/css" href="${root}vendor/select2/select2.min.css">
	<link rel="stylesheet" type="text/css" href="${root}vendor/daterangepicker/daterangepicker.css">
	<link rel="stylesheet" type="text/css" href="${root}css/util.css">
	<link rel="stylesheet" type="text/css" href="${root}css/main.css?after">

	<script src="${root}vendor/animsition/js/animsition.min.js"></script>
	<script src="${root}vendor/bootstrap/js/popper.js"></script>
	<script src="${root}vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="${root}vendor/select2/select2.min.js"></script>
	<script src="${root}vendor/daterangepicker/moment.min.js"></script>
	<script src="${root}vendor/daterangepicker/daterangepicker.js"></script>
	<script src="${root}vendor/countdowntime/countdowntime.js"></script>
	<script src="js/main.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	  $('#summernote').summernote({
		    placeholder: '상세 설명을 입력하세요',
		    tabsize: 2,
		    height: 500,
		    toolbar: [
		    	['fontname', ['fontname']],
			    ['fontsize', ['fontsize']],
			    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
			    ['color', ['forecolor','color']],
			    ['table', ['table']],
			    ['para', ['ul', 'ol', 'paragraph']],
			    ['height', ['height']],
			    ['insert',['picture','link','video']],
			    ['view', ['fullscreen', 'help']]
		    ],
		    fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
			fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
			callbacks: {	//여기 부분이 이미지를 첨부하는 부분
				onImageUpload : function(files) {
					uploadSummernoteImageFile(files[0],this);
				},
				onPaste: function (e) {
					var clipboardData = e.originalEvent.clipboardData;
					if (clipboardData && clipboardData.items && clipboardData.items.length) {
						var item = clipboardData.items[0];
						if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
							e.preventDefault();
						}
					}
				}
			}
	  });
	});

//이미지 파일 업로드
function uploadSummernoteImageFile(file, editor) {
	data = new FormData();
	data.append("file", file);
	$.ajax({
		data : data,
		type : "POST",
		url : "/uploadSummernoteImageFile",
		contentType : false,
		processData : false,
		success : function(data) {
        	//항상 업로드된 파일의 url이 있어야 한다.
			$(editor).summernote('insertImage', data.url);
		}
	});
}
</script>

</head>
<body>
	<!-- 상단 메뉴 -->
	<c:import url="/WEB-INF/view/include/top_menu.jsp" />
	<c:import url="/WEB-INF/view/include/category_menu.jsp" />
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-form-title" style="background-image: url(${root}images/bg-02.jpg);">
					<span class="login100-form-title-1">상품등록</span>
				</div>
		
				<form:form action="${root }product/register" method="post" modelAttribute="productDTO" class="login100-form validate-form" enctype="multipart/form-data">
					<div class="wrap-input100 validate-input m-b-26">
						<span class="label-input100">상품이름</span> 
						<form:input path="pr_name" class="input100" placeholder="상품이름 입력"/> 
						<span class="focus-input100"></span>
						<form:errors path="pr_name" style="color:red;"/>
					</div>
			
					<div class="wrap-input100 validate-input m-b-26">
						<span class="label-input100">카테고리</span>
						<form:select path="pr_category">
							<c:forEach var="category" items="${categoryList}" begin="2">
								<option value=${category.category_idx}>${category.category_name}</option>
							</c:forEach>
						</form:select>
					</div>
					
					<div class="wrap-input100 validate-input m-b-26">
						<span class="label-input100">대표 이미지</span>
						<input type="file" id="gdsImg" name="file" />
						<br><br>
						<form:errors path="pr_image" style="color:red;"/>
					</div>
						

					<div class="wrap-input100 validate-input m-b-26">
						<span class="label-input100">상품 가격</span>
						<form:input path="pr_price" class="input100" placeholder="상품가격 입력"/>
						<span class="focus-input100"></span>
						<form:errors path="pr_price" style="color:red;"/>
					</div>
					
					<div class="wrap-input100 validate-input m-b-26">
						<span class="label-input100">상품설명</span> 
						<form:input path="pr_description" class="input100" placeholder="상품설명 입력"/>
						<span class="focus-input100"></span>
						<form:errors path="pr_description" style="color:red;"/>
					</div>
					
					<div class="wrap-input100 validate-input m-b-26">
						<span class="label-input100">사이즈</span>
						<form:input path="pr_size" class="input100" placeholder="상품사이즈 입력(,로 구분하여 입력)"/>
						<span class="focus-input100"></span>
						<form:errors path="pr_size" style="color:red;"/>
					</div>
					
					<div class="wrap-input100 validate-input m-b-26">
						<span class="label-input100">색상</span> 
						<form:input path="pr_color" class="input100" placeholder="상품색상 입력(,로 구분하여 입력)"/>
						<span class="focus-input100"></span>
						<form:errors path="pr_color" style="color:red;"/>
					</div>
					
					<div class="wrap-input100 validate-input m-b-26">
						<span class="label-input100">재고</span>
						<form:input path="pr_stock" class="input100" placeholder="상품재고 입력"/>
						<span class="focus-input100"></span>
						<form:errors path="pr_stock" style="color:red;"/>
					</div>		
					
					<div class="wrap-input100 validate-input m-b-26">
						<span class="label-input100">상세설명</span>
						<textarea id="summernote" name="pr_detail"></textarea>
					</div>
					
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">등록</button>
					</div>
				</form:form>	
			</div>
		</div>
	</div>
	
	<c:import url="/WEB-INF/view/include/bottom_info.jsp" />
</body>
</html>