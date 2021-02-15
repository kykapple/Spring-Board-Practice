<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 등록</title>
<style type="text/css">
	.body { text-align: center; }
	.table { margin: auto; }
</style>
</head>
<body class="body">

	<h1>글 등록</h1>
	<a href="logout.do">Log-out</a>
	<hr>
	
	<form action="insertBoard.do" method="post" enctype="multipart/form-data">
		<table border="1" cellpadding="0" cellspacing="0" class="table">
			<tr>
				<td bgcolor="orange" width="70">제목</td>
				<td align="left"><input type="text" name="title"></td>
			</tr>
			<tr>
				<td bgcolor="orange">작성자</td>
				<td align="left"><input type="text" name="writer" size="10"></td>
			</tr>
			<tr>
				<td bgcolor="orange">내용</td>
				<td align="left"><textarea rows="10" cols="40" name="content"></textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">업로드</td>
				<td align="left"><input type="file" name="uploadFile"></input></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="새글 등록"></td>
			</tr>
		</table>
	</form>
	
	<hr>
	<a href="getBoardList.do">글 목록 가기</a>

</body>
</html>