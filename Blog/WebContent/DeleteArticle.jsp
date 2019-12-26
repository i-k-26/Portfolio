<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jp.joyworks.blog.dto.UserDTO" %>
<%
	//セッションスコープからユーザー情報を取得
	UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
	String deletearticletitle = (String) session.getAttribute("deleteArticleTitle");
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>記事削除</title>
</head>

<body>
	<% if (loginUser != null) { %>

	<p>記事を削除しますか？
	<p>
	<p>記事名:<%= deletearticletitle %></p>

	<form action="DeleteArticleServlet" method="post">
	はい<input type="radio" name="deleteFlg" value="1">
	いいえ<input type="radio">
	<br>
	<input type="submit" value="OK">
	</form>

	<br><br>

	<p>
		<a href=/Blog/MyPage.jsp>マイページ</a>へ
	</p>

	<p>
		TOPは<a href="/Blog/TopPageServlet">こちら</a>。
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