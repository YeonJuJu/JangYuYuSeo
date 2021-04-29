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
    <title>JSP</title>
    
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
	  $('#summernote').summernote();
	});
</script>

<script>
$('#summernote').summernote({
    placeholder: 'Hello Bootstrap 4',
    tabsize: 2,
    height: 100,
    toolbar: [
      ['style', ['style']],
      ['font', ['bold', 'underline', 'clear']],
      ['color', ['color']],
      ['para', ['ul', 'ol', 'paragraph']],
      ['table', ['table']],
      ['insert', ['link', 'picture', 'video']],
      ['view', ['fullscreen', 'codeview', 'help']]
    ]
  });
</script>
</head>
<body>
	<!-- 상단 메뉴 -->
	<c:import url="/WEB-INF/view/include/top_menu.jsp" />
	<c:import url="/WEB-INF/view/include/category_menu.jsp" />

    <%-- <form method="post" style="margin-top:140px">
	  <textarea id="summernote" name="editordata"></textarea>
	</form> --%>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-form-title"
					style="background-image: url(${root}images/bg-02.jpg);">
					<span class="login100-form-title-1">상품등록</span>
				</div>
			</div>
		</div>
		<textarea id="summernote" name="editordata"></textarea>
		<form:form action="${root }product/register" method="post" class="login100-form validate-form" enctype="multipart/form-data">
			<div class="wrap-input100 validate-input m-b-26">
				<span class="label-input100">상품이름</span> 
				
				<span class="focus-input100"></span>
			</div>
		</form:form>
	</div>
	
	<c:import url="/WEB-INF/view/include/bottom_info.jsp" />
</body>
</html>