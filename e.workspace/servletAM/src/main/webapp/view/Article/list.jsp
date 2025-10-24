<%@page import="java.util.ArrayList"%>
<%@page import="com.koreaIT.servletAM.dto.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. request에서 List<Article> 객체를 가져옵니다.
	// NullPointerException 방지를 위해 List<?> 타입으로 캐스팅합니다.
	List<Article> articles = (List<Article>)request.getAttribute("articles");
	
	// articles가 null일 경우를 대비하여 빈 리스트로 초기화합니다.
	if (articles == null) {
		articles = new ArrayList<>();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LIST</title>
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
    <h1>게시물 리스트 (<%=articles.size()%>개)</h1>
    
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>작성일</th>
                <th>제목</th>
                <th>조회수</th>
            </tr>
        </thead>
        <tbody>
            <%if(articles.isEmpty()) {%>
                <tr>
                    <td colspan="4" style="text-align:center;">게시물이 존재하지 않습니다.</td>
                </tr>
            <%} else {%>
                <%for(Article article : articles){ %>
                <tr>
                    <td><%=article.getId()%></td>
                    <td><%=article.getRegDate()%></td>
                    <td><a href="/usr/article/detail?id=<%=article.getId()%>"><%=article.getTitle()%></a></td>
                    <td><%=article.getViewCnt()%></td>
                </tr>
                <%} %>
            <%} %>
        </tbody>
    </table>
</body>
</html>