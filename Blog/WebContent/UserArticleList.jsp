<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jp.joyworks.blog.dto.UserDTO"
	import="jp.joyworks.blog.dto.ArticleDTO" import="java.util.List"%>
<%
	//セッションスコープからユーザー情報を取得
	UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
	List<ArticleDTO> articlelist = (List<ArticleDTO>) session.getAttribute("articleList");
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>記事一覧</title>
</head>

<body>
	<%
		if (loginUser != null && articlelist != null) {
	%>

	<table border="1">
		<thead>
			<tr>
				<th>title</th>
				<th>category</th>
				<th>post_date</th>
				<th>status</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>

			<%
				for (ArticleDTO data : articlelist) {
			%>
			<tr>
				<td><%=data.getTitle()%></td>
				<td><%=data.getCategory()%></td>
				<td><%=data.getPost_date()%></td>
				<td>
					<%
						if (data.getStatus()) {
					%>
					<p>公開</p>
					<% } else { %>
					<p>非公開</p>
					<% } %>
				</td>
				<td><form action="UpeditArticleServlet" method="get">
						<input type="hidden" name="editTitle" value="<%=data.getTitle()%>">
						<input type="hidden" name="editArticleID" value="<%=data.getId()%>">
						<input type="submit" name="<%=data.getId()%>" value="編集">
					</form></td>
				<td><form action="DeletePreparationServlet" method="get">
						<input type="hidden" name="deleteTitle" value="<%=data.getTitle()%>">
						<input type="hidden" name="deleteArticleID" value="<%=data.getId()%>">
						<input type="submit" name="<%=data.getId()%>" value="削除">
					</form></td>


			</tr>
			<%
				}
			%>
		</tbody>
	</table>

	<p>
		<a href=/Blog/MyPage.jsp>マイページ</a>へ
	</p>

	<p>
		TOPは <a href="/Blog/TopPageServlet">こちら</a>。
	</p>

	<%
		} else if (loginUser != null && articlelist == null) {
	%>

	<p>過去の記事はありません</p>

	<br>

	<p>
		<a href=/Blog/MyPage.jsp>マイページ</a>へ
	</p>

	<p>
		TOPは <a href="/Blog/TopPageServlet">こちら</a>。
	</p>


	<%
		} else {
	%>

	<p>
		<span style="color: red">ユーザー情報が確認できません</span>
	</p>
	<p>ログインしてください</p>
	<a href="/Session/Login.jsp">ログインへ</a>

	<%
		}
	%>

</body>
</html>