<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<base href="/" />
<meta charset="UTF-8">
<title><spring:message code="common.home" /></title>
<link rel="stylesheet" href="resources/css/homeStyle.css" >
</head>
<body>
	<div class="b_div">
		<div>
			<h2><spring:message code="common.board" /></h2>
		</div>
		
		<sec:authorize access="isAnonymous()">
		<div class="btn_div">
		<spring:message code="auth.signup.kr" var="signup" />
		<input type="button" value="${signup}" onclick="onClickSignUp()" />
		<spring:message code="auth.login.kr" var="login" />
		<input type="button" value="${login }" onclick="onClickLogIn()" />
		</div>
		</sec:authorize>
		
		<sec:authorize access="isAuthenticated()">
		<div class="btn_div">
		<spring:message code="auth.logout.kr" var="logout" />
		<input type="button" value="${logout }" id="logoutBtn" onclick="onClickLogOut()" />
		</div>
		</sec:authorize>
			
		<div class="t_div">
			<table>
				<tr>
					<th style="width:15%"><spring:message code="common.no" /></th>
					<th style="width:70%"><spring:message code="common.title" /></th>
					<th style="width:15%"><spring:message code="common.writer" /></th>
					<th style="width:15%"><spring:message code="common.created" /></th>
					<th style="width:15%"><spring:message code="common.hits" /></th>
				</tr>
				<c:forEach var="dto" items="${dto}">
					<tr>
						<td>${dto.id }</td>
						<td><a href="board/view?num=${dto.id }">${dto.title }</a></td>
						<td>${dto.writer }</td>
						<td style="font-size: 0.8em" >${dto.regDate }</td>
						<td>${dto.hits }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<sec:authorize access="isAnonymous()">
		<div class="btn_div">
			<br> 
			<spring:message code="common.write" var="write" />
			<input type="button" value="${write}" id="writeBtn1" onclick="onClickWriteBtn1()" />
		</div>
		</sec:authorize>
		
		<sec:authorize access="isAuthenticated()">
		<div class="btn_div">
			<spring:message code="common.write" var="write" />
			<br> <input type="button" value="${write}" id="writeBtn2" onclick="location.href='board/write'" />
		</div>
		</sec:authorize>
		
		<br>
		<div class="page_wrap">
			<div class="page_nation">
				<c:if test="${board.prev}">
					<a class="arrow prev" href="board/home?page=${board.start - 1}"><spring:message code="board.prev" /></a>
				</c:if>
				<c:forEach var="page" items="${board.pageList }">
					<a href="board/home?page=${page}"> <c:out value="${page}">
						</c:out></a>

				</c:forEach>
				<c:if test="${board.next}">
					<a class="arrow next" href="board/home?page=${board.end + 1}"><spring:message code="board.next" /></a>
				</c:if>
			</div>
		</div>
	</div>
</body>
<script src="resources/js/homeButton.js"></script>
</html>