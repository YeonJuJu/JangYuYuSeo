<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!-- 절대 경로 설정 -->
<c:url var="root" value="/" />

<!-- 상단 메뉴 부분 -->
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
  
  
  <a class="navbar-brand" href="${root }main">JangYuYuSeo</a>
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a href="${root }user/login" class="nav-link">Login<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a href="${root }user/join" class="nav-link">Join</a>
      </li>
      <li class="nav-item">
        <a href="${root }main" class="nav-link">Logout<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a href="${root }main" class="nav-link">MyPage</a>
      </li>
      <li class="nav-item">
        <a href="${root }main" class="nav-link">Shopping Basket</a>
      </li>
    </ul>
  </div>

	
</nav>



