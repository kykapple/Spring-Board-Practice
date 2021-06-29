<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	.body { text-align: center; }
	.table { margin: auto; }
</style>
</head>
<body class="body">

	<h1>회원가입</h1>
	<hr>

	<form action="join.do" method="post">
		<table border="1" cellspacing="0" cellpadding="0" class="table">
			<tr>
				<td bgcolor="orange">이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td bgcolor="orange">아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td bgcolor="orange">비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="회원가입"></td>
			</tr>
		</table>
	</form>
	
	<hr>
	<a href="login.jsp">돌아가기</a>

</body>
</html>