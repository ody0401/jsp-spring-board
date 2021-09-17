<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<base href="/" />
<meta charset="UTF-8">
<title><spring:message code="common.write" /></title>
<link rel="stylesheet" type="text/css"
	href="resources/css/writeStyle.css">
<body>
	<form method="post" action="board/write?num=${dto.id }">
		<table>
			<tr>
				<td height=20 align=center bgcolor=#ccc><font color=white>
						<spring:message code="common.write" />
				</font></td>
			</tr>
			<tr>
				<td bgcolor=white>
					<table class="table2">
						<tr>
							<td><spring:message code="common.title" /></td>
							<td><input type=text name="title" size=60
								value="${dto.title }" required="required"></td>
						</tr>

						<tr>
							<td><spring:message code="common.content" /></td>
							<td><textarea name="content" cols=85 rows=15
									required="required">${dto.content }</textarea></td>
						</tr>
					</table>

					<div style="float: right; margin-right: 15px;">
						<input type="submit" value="작성">
						<input id="backBtn" type="button" value="취소">
					</div>
				</td>
			</tr>
		</table>
	</form>
</body>
<script src="resources/js/button.js"></script>
</html>