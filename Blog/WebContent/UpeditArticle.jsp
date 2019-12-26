<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jp.joyworks.blog.dto.ArticleDTO" import="jp.joyworks.blog.dto.UserDTO" %>
<%
	//セッションスコープからユーザー情報を取得
	UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
	ArticleDTO articlelog = (ArticleDTO) request.getAttribute("articleLog");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>記事画面</title>
</head>

<body>

<% if (loginUser != null && articlelog == null) { %>

	<p>
		ログインユーザー:<%=loginUser.getName()%>さん
	</p>

	<h2>新規記事作成</h2>

	<form action="/Blog/PostDoneArticleServlet" method="post">
	<p>タイトル</p>
	<input type="text" name="Title" required="required">
	<p>カテゴリ</p>
	<input type="text" name="Category" required="required">
	<p>本文</p>
	<input type="text" name="Article" required="required">
	<br>
	<p>公開設定</p>
	公開<input type="radio" name="Status" value="1" checked>
	非公開<input type="radio" name="Status" value="0">
	<br>
	<input type="submit" name="Create" value="投稿">
	</form>

	<br><br><br>

	<p><a href=/Blog/MyPage.jsp>マイページ</a>へ</p>

	<p>TOPは
	<a href="/Blog/TopPageServlet">こちら</a>。</p>

	<%	} else if(loginUser != null && articlelog != null) { %>

	<p>
		ログインユーザー:<%=loginUser.getName()%>さん
	</p>

	<h2>記事編集</h2>

	<form action="/Blog/PostDoneArticleServlet" method="post">
	<p>タイトル</p>
	<input type="text" name="Title" value=<%= articlelog.getTitle() %> required="required">
	<p>カテゴリ</p>
	<input type="text" name="Category" value=<%= articlelog.getCategory() %> required="required">
	<p>本文</p>
	<input type="text" name="Article" value=<%= articlelog.getArticle() %> required="required" >
	<br>
	<p>公開設定</p>
	公開<input type="radio" name="Status" value="1">
	非公開<input type="radio" name="Status" value="0">
	<br>
	<input type="hidden" name="ArticleID" value=<%= articlelog.getId() %>>
	<input type="submit" name="Edit" value="編集">
	</form>

	<br><br><br>

	<p><a href=/Blog/MyPage.jsp>マイページ</a>へ</p>

	<p>TOPは
	<a href="/Blog/TopPageServlet">こちら</a>。</p>


	<%	} else { %>

	<p>
		<span style="color: red">ユーザー情報が確認できません</span>
	</p>
	<p>ログインしてください</p>
	<a href="/Session/Login.jsp">ログインへ</a>


	<% } %>

</body>
</html>