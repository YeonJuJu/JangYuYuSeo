<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>    
<script type="text/javascript">
	alert('상품등록 완료되었습니다.');
	//location.href='${root}/product/manage';
	location.href='${root}product/display?product_id=${pr_id}';
</script>