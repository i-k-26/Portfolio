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
<title>記事編集</title>
</head>

<body>
<% if (loginUser != null) { %>

	<p>
		ログインユーザー:<%=loginUser%>さん
	</p>
	<form action="/Blog/CompleteArticleServlet" method="post">
	<p>タイトル</p>
	<input type="text" name="Title">
	<p>カテゴリ</p>
	<input type="text" name="Category">
	<p>本文</p>
	<input type="text" name="Article">
	<br>
	<p>公開設定</p>
	公開<input type="radio" name="Status" value="0">
	非公開<input type="radio" name="Status" value="1">
	<br>
	<input type="submit" name="Edit" value="編集">
	</form>

	<br><br><br>

	<p><a href=/Blog/MyPage.jsp>マイページ</a>へ</p>

	<p>TOPは
	<a href="/Blog/TopPage.jsp">こちら</a>。</p>

	<%	} else { %>

	<p>
		<span style="color: red">ユーザー情報が確認できません</span>
	</p>
	<p>ログインしてください</p>
	<a href="/Session/Login.jsp">ログインへ</a>

	<% } %>


</body>
</html>