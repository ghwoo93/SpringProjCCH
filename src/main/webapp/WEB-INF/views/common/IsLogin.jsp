<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 스프링 씨큐리티 미 사용 -->
<c:if test="${empty sessionScope.id}">
	<script>
		alert("로그인 후 이용하세요");
		location.replace("<c:url value="/OneMemo/Auth/Login.do"/>");
	</script>
</c:if>


<!-- 스프링 씨큐리티 사용 -->