<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//セッションスコープからユーザー情報を取得
	String loginUser = (String) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TOP</title>
</head>
<body>
	<% if (loginUser != null) { %>
<p>マイページ</p>
<input type="button" value="マイページ" onclick="location.href='/Blog/MyPage.jsp'">

	<%	} else { %>

<p>ログイン<p>
<input type="button" value="ログイン" onclick="location.href='/Blog/Login.jsp'">

<% } %>

<br><br>
<p>記事検索</p>
<form action="/Blog/SearchServlet" method="post">
<input type="search" name="Search">
<input type="submit" value="検索">
</form>
<br>
<p>記事リスト</p>


</body>
</html>