<%@page import="com.koreaIT.servletAM.dto.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Article article = (Article)request.getAttribute("article");

    	if (article == null) {
		article = new Article();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
<style>
body, ul, li {
    margin: 0;
    list-style: none;
}

table {
    width: 80%;
    border-collapse: collapse;
}

th, td {
    border: 1px solid #ccc;
    padding: 8px;
    text-align: left;
}
</style>
</head>
<body>
<h1>자세히보기(<%=article.getId()%>번째 게시물)</h1>
<table>
    <thead>
        <tr>
            <th>번호</th>
            <th>작성일</th>
            <th>제목</th>
            <th>내용</th> 
            <th>조회수</th>
        </tr>
    </thead>
    <tbody>
        <%if (article.getId() == 0) { %>
            <tr>
                <td colspan="5">
                    요청하신 게시물은 존재하지 않거나 삭제되었습니다.
                    <a href="../list">목록으로 돌아가기</a>
                </td>
            </tr>
        <%} else {%>
            <tr>
                <td><%=article.getId()%></td>
                <td><%=article.getRegDate()%></td>
                <td><%=article.getTitle()%></td>
                <td><%=article.getContent()%></td> 
                <td><%=article.getViewCnt()%></td>
            </tr>
        <%} %>
    </tbody>
</table>
</body>
</html>