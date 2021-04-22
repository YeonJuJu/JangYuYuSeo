<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    


<!-- 절대 경로 설정 -->
<c:url var="root" value="/" />

<div class="nav-scroller py-1 mb-2 fixed-top" style="margin-top:70px">
		<nav class="nav ml-auto">
			
			<c:forEach var="categoryDTO" items="${categoryList}">
					<a class="p-2 text-muted" href="${root }product/list?category_idx=${categoryDTO.category_idx}">${categoryDTO.category_name}</a>
			</c:forEach>
			
			<form class="form-inline ml-auto" style="margin-right:0px">
			    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
			    <button class="btn btn-sm btn-outline-secondary" type="button">Search</button>
			</form>
		</nav>
		
		
</div>