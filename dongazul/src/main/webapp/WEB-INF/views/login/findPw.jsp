<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findPw.jsp</title>
</head>
<body>
	<h1>비밀번호 찾기 화면</h1>
	<h1>/WEB-INF/views/login/findPw.jsp</h1>
	<form action="/login/findPwResult" method="post">
		<p>이메일 입력</p>
		<input type="text" id="email" name="email">
		<!-- <p>전화번호 입력</p>
		<input type="number" id="phonenumber" name="phonenumber"> -->
		<input type="submit" value="비밀번호 찾기">
	</form>
</body>
</html>