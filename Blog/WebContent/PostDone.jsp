<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//リクエストスコープから1回だけ使える情報を取得
	String create = (String) request.getAttribute("create");
	String edit = (String) request.getAttribute("edit");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>作業完了</title>
</head>
<body>
	<% if (create != null && edit == null) { %>

	<p>記事の投稿が完了しました。</p>
	<a href=/Blog/MyPage.jsp>マイページ</a>へ

	<br><br><br>

	TOPは<a href="/Blog/TopPageServlet">こちら</a>

	<%	} else if (create == null && edit != null) {  %>
	<p>記事の編集が完了しました。</p>

	<a href=/Blog/MyPage.jsp>マイページ</a>へ

	<br><br><br>

	TOPは<a href="/Blog/TopPageServlet">こちら</a>

	<% } else { %>

	<p>
		<span style="color: red">ユーザー情報が確認できません</span>
	</p>
	<p>ログインしてください</p>
	<a href="/Session/Login.jsp">ログインへ</a>

	<% } %>


</body>
</html>