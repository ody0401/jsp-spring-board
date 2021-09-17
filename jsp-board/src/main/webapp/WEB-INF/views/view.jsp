<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<base href="/" />
<meta charset="UTF-8">
<title><spring:message code="common.view" /></title>
<link rel="stylesheet" type="text/css"
	href="resources/css/writeStyle.css">
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
					<input type="button" value="${update }" onclick="location.href='board/write?num=${dto.id}'"> 
					<spring:message code="common.delete" var="delete" />
					<input id="delBtn" type="button" value="${delete }" >
					<spring:message code="common.back" var="back" />
					<input id="backBtn" type="button" value="${back }">
				</div>
			</td>
		</tr>
	</table>
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
</html>