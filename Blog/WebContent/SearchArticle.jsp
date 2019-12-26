<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jp.joyworks.blog.dto.ArticleDTO" import="java.util.List"%>
<%
    List<ArticleDTO> search = (List<ArticleDTO>) session.getAttribute("SearchArticle");
%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>

<body>


<p>検索結果</p>
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
				for (ArticleDTO data : search) {
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