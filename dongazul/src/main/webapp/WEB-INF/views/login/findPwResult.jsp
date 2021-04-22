<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>findPwResult.jsp</title>
</head>
<body>
	<h1>비밀번호 찾기 결과</h1>
	
	비밀번호 : ${ findPw }
	<hr>
	<form action="/login/signIn" method="get">
		<input type="submit" value="홈으로 돌아가기">
	</form>
</body>
</html>