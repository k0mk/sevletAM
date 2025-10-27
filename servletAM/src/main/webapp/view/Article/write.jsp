<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
</head>
<body>
   <form action="/usr/article/Dowrtie" method="get">
   <table>
      <tr>
         <th>제목</th>
         <td><input type="text"  name="title" /></td>
      </tr>
      <tr>
         <th>내용</th>
         <td><input type="text" name="content" /></td>
      </tr>
      <tr>
      	<th colspan = "2"><button>작성</button></th>
      </tr>
   </table>
   </form>
<div><button onclick="history.back();">뒤로가기</button></div>
</body>
</html>