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
<title>記事削除</title>
</head>

<body>
	<% if (loginUser != null) { %>

	<p>記事を削除しますか？
	<p>
	<p>記事1</p>

	<form action="DeleteArticleServlet" method="post">
	はい<input type="radio" name="deleteflg" value="1">
	いいえ<input type="radio">
	<br>
	<input type="submit" value="OK">
	</form>

	<br><br>

	<p>
		<a href=/Blog/MyPage.jsp>マイページ</a>へ
	</p>

	<p>
		TOPは<a href="/Blog/TopPage.jsp">こちら</a>。
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