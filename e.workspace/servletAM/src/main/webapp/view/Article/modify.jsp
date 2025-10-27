<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify</title>
</head>
<body>
	<form action="/usr/article/Domodify" method="get">
	<input type="hidden" value="<%= request.getAttribute("id")%>" name="id"/>
		<table>
			<tr>
				<th>수정할 제목</th>
				<td><input type="text" value="" name="title" /></td>
			</tr>
			<tr>
				<th>수정할 내용</th>
				<td><input type="text" value="" name="content" /></td>
			</tr>
			<tr>
				<th colspan="2"><button>수정</button></th>
			</tr>
		</table>
	</form>
	<div><button onclick="history.back();">뒤로가기</button></div>
</body>
</html>