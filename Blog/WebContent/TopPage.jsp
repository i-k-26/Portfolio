<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jp.joyworks.blog.dto.UserDTO" import="jp.joyworks.blog.dto.ArticleDTO" import="java.util.List"%>
<%
	//セッションスコープからユーザー情報を取得
	UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
	List<ArticleDTO> recently = (List<ArticleDTO>) session.getAttribute("recentlyArticles");
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
	<input type="button" value="マイページ"
		onclick="location.href='/Blog/MyPage.jsp'">

	<%	} else { %>

	<p>ログイン
	<p>
		<input type="button" value="ログイン"
			onclick="location.href='/Blog/Login.jsp'">

		<% } %>

		<br>
		<br>
	<p>記事検索</p>
	<form action="/Blog/SearchServlet" method="get">
		<input type="search" name="Search">
		<input type="submit" value="検索">
	</form>
	<br>
	<p>記事リスト</p>
	<table border="1">
		<thead>
			<tr>
				<th>投稿者</th>
				<th>タイトル</th>
				<th>カテゴリ</th>
				<th>投稿日時</th>
			</tr>
		</thead>
		<tbody>

			<%
				for (ArticleDTO data : recently) {
			%>
			<tr>
				<td><%=data.getUser_name()%></td>
				<td><%=data.getTitle()%></td>
				<td><%=data.getCategory()%></td>
				<td><%=data.getPost_date()%></td>
				<td><form action="/Blog/ArticleServlet" method="get">
						<input type="hidden" name="ArticleID"value="<%=data.getId()%>">
						<input type="submit" value="記事を見る">
					</form></td>

			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>