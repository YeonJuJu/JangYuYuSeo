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
      <c:choose>
      	<c:when test="${loginUserDTO.isUserLogin()==true }">
      			<c:if test="${loginUserDTO.getUser_idx()=='0' }">
      				<li class="nav-item">
        				<a href="${root }product/manage" class="nav-link">Manage<span class="sr-only">(current)</span></a>
      				</li>
      			</c:if>
   
      			<li class="nav-item">
        			<a href="${root }user/logout" class="nav-link">Logout<span class="sr-only">(current)</span></a>
	      		</li>
	      		<li class="nav-item">
	        		<a href="${root }user/myPage" class="nav-link">MyPage</a>
	      		</li>
      	</c:when>
      	<c:otherwise>
      		<li class="nav-item">
        		<a href="${root }user/login" class="nav-link">Login<span class="sr-only">(current)</span></a>
      		</li>
      		<li class="nav-item">
        		<a href="${root }user/join" class="nav-link">Join</a>
      		</li>
      	</c:otherwise>
      </c:choose>
      <li class="nav-item">
        <a href="${root }cart/list" class="nav-link">Cart</a>
      </li>
    </ul>
  </div>
</nav>



