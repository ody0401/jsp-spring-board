<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<base href="/" />
<meta charset="UTF-8">
<title><spring:message code="common.view" /></title>
<link rel="stylesheet" type="text/css"
	href="resources/css/writeStyle.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/replyStyle.css">
</head>
<body>
	<table>
		<tr>
			<td height=20 align=center bgcolor=#ccc><font color=white>
					<spring:message code="common.view" />
			</font></td>
		</tr>
		<tr>
			<td bgcolor=white>
				<table class="table2">
					<tr>
						<td><spring:message code="common.writer" /></td>
						<td><input readonly="readonly" disabled="disabled"
							value="${dto.writer }" /></td>
					</tr>

					<tr>
						<td><spring:message code="common.title" /></td>
						<td><input readonly="readonly" disabled="disabled"
							value="${dto.title }" /></td>
					</tr>

					<tr>
						<td><spring:message code="common.content" /></td>
						<td><textarea name="content" cols=85 rows=15
								readonly="readonly" disabled="disabled">${dto.content }</textarea></td>
					</tr>
				</table>

				<div style="float: right; margin-right: 15px;">
					<spring:message code="common.update" var="update" />
					<input type="button" value="${update }"
						onclick="location.href='board/write?num=${dto.id}'">
					<spring:message code="common.delete" var="delete" />
					<input id="delBtn" type="button" value="${delete }">
					<spring:message code="common.back" var="back" />
					<input id="backBtn" type="button" value="${back }">
				</div>
			</td>
		</tr>
	</table>



	<div class="replyDiv" >
		<h3>
			댓글 <span><button onclick="onClickReplyDisplay()">댓글 숨기기</button></span>
		</h3>
		<hr />
		<div class="dvdv" id="dvdvDiv">
			<c:forEach var="reply" items="${reply}">
				<c:forEach var="member" items="${reply.memberList}">
					<fmt:parseDate value="${reply.updDate}"
						pattern="yyyy-MM-dd'T'HH:mm" var="dateTime" />
					<hr />
					<div class="flex">

						<c:if test="${reply.step>0 }">
							<c:forEach begin="1" end="${reply.step}">
								<div class="icon">⎿</div>
							</c:forEach>
						</c:if>

						<div class="flex_1">
							<div class="inner">
								<div>
									<span>${member.userName }</span>
								</div>
								<div>
									<p>${reply.reply }</p>
								</div>
								<div>
									<p class="created">
										<fmt:formatDate value="${dateTime}"
											pattern="yyyy-MM-dd HH:mm" />
									</p>
									<button id="${reply.id}" onclick="onClickDisplay(this)">답글</button>
								</div>
							</div>

							<div id="reply${reply.id}" class="hiddenDiv">
							<hr />
								<div class="reply_div">
									<div class="icon">⎿</div>
									<sec:authorize access="isAuthenticated()">
										<form method="post" action="board/reply">
											<div class="textarea-container">
												<textarea name="reply" placeholder="댓글을 입력해주세요"></textarea>
												<input type="hidden" name="step" value="${reply.step+1}" />
												<input type="hidden" name="ref" value="${reply.ref}" /> <input
													type="hidden" name="refOrder" value="${reply.refOrder}" />
												<input type="hidden" name="stepOrder" value="${reply.id}" />
												<input type="hidden" name="boardNo" value="${dto.id }" />
												<button type="submit">등록</button>
											</div>
										</form>
									</sec:authorize>
									<sec:authorize access="!isAuthenticated()">
										<div class="notLogin">
											<p>
												<a href="user/login">로그인이 필요합니다</a>
											</p>
										</div>
									</sec:authorize>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:forEach>

			<hr />
			<sec:authorize access="isAuthenticated()">
				<form class="inner" method="post" action="board/reply">
					<div class="textarea-container">
						<textarea name="reply" placeholder="댓글을 입력해주세요"></textarea>
						<input type="hidden" name="boardNo" value="${dto.id }" />
						<button type="submit">등록</button>
					</div>
				</form>
			</sec:authorize>

			<sec:authorize access="!isAuthenticated()">
				<div class="notLogin">
					<p>
						<a href="user/login">로그인이 필요합니다</a>
					</p>
				</div>
			</sec:authorize>
		</div>
	</div>
	<script>
		function delBtnClick() {
			var x = confirm("게시물을 삭제하시겠습니까?");

			if (x) {
				return location.href = 'board/delete?num=${dto.id}';
			}

		}

		var delBtn = document.getElementById("delBtn").addEventListener(
				"click", delBtnClick);
	</script>
</body>
<script src="resources/js/button.js"></script>
<script src="resources/js/replyButton.js"></script>
</html>