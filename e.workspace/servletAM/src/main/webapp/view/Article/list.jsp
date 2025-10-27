<%@page import="java.util.ArrayList"%>
<%@page import="com.koreaIT.servletAM.dto.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Article> articles = (List<Article>)request.getAttribute("articles");
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
                <th>제목</th>
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
                    <td><a onclick="return confirmDelete();" href="/usr/article/delete?id=<%=article.getId()%>" style="font-size: 4rem;">Delete</a></td>
                </tr>
                <%} %>
            <%} %>
        </tbody>
    </table>
    <div><button onclick="history.back();">뒤로가기</button></div>
    <script>
   	function confirmDelete() {
		let result = confirm("정말 삭제하시겠습니까? (확인=예, 취소=아니요)")
    if (result) {
    console.log("사용자가 '예'를 선택했습니다. 작업을 진행합니다.");
    return true;
} else {
    console.log("사용자가 '아니요'를 선택했습니다. 작업을 취소합니다.");
    return false;
}
	}
    
    </script>
</body>
</html>