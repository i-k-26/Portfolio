<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jp.joyworks.blog.dto.ArticleDTO"%>
<%
	//セッションスコープからユーザー情報を取得
	ArticleDTO readarticle = (ArticleDTO) request.getAttribute("ReadArticle");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= readarticle.getTitle() %></title>
</head>
<body>
<div>
	<p><%= readarticle.getUser_name() %>さんの記事</p>

	<h1><%= readarticle.getTitle() %></h1>
	<br>
</div>

<div>
	<p><%= readarticle.getArticle() %></p>
</div>

<div>
	<br><br>
	<p>カテゴリ:<%= readarticle.getCategory() %></p>
</div>

<div>
<p>投稿日時:<%= readarticle.getPost_date() %></p>
</div>

<br><br>


<p>TOPは
	<a href="/Blog/TopPageServlet">こちら</a>。</p>

</body>
</html>