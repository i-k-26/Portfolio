<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//スコープから情報を取得
	String error = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログインページ</title>
</head>
<body>

	<% if (error != null) { %>

	<span style="color: red"><%=error%></span>
	<br>

	<% } %>


	登録したユーザー情報を入力してください。

	<form action="/Blog/LoginServlet" method="post">
		<span style="text-align: justify; text-justify: inter-ideograph;">ユーザー名：</span>
		<input type="text" name="User_ID" required="required"><br>
		<span style="text-align: justify; text-justify: inter-ideograph;">パスワード：</span>
		<input type="password" name="PASS" required="required"><br>
		<input type="submit" value="ログイン">
	</form>

	<br>
	<br> TOPページは
	<a href="/Blog/TopPage.jsp">こちら</a>。

</body>
</html>