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
<title>記事一覧</title>
</head>

<body>
	<% if (loginUser != null) { %>

	<p>記事1</p>
	<form action="EditArticleServlet" method="get">
		<input type="submit" value="編集">
	</form>
	<input type="button" value="削除" onclick="location.href='/Blog/DeleteArticle.jsp'">

	<p>記事2</p>
	<form action="EditArticleServlet" method="get">
		<input type="submit" value="編集" >
	</form>
	<input type="button" value="削除" onclick="location.href='/Blog/DeleteArticle.jsp'">

	<p>記事3</p>
	<form action="EditArticleServlet" method="get">
		<input type="submit" value="編集" >
	</form>
	<input type="button" value="削除" onclick="location.href='/Blog/DeleteArticle.jsp'">

	<p>
		<a href=/Blog/MyPage.jsp>マイページ</a>へ
	</p>

	<p>
		TOPは <a href="/Blog/TopPage.jsp">こちら</a>。
	</p>

	<% } else { %>

	<p>
		<span style="color: red">ユーザー情報が確認できません</span>
	</p>
	<p>ログインしてください</p>
	<a href="/Session/Login.jsp">ログインへ</a>

	<% } %>

</body>
</html>