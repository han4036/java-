<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>findIdResult.jsp</title>
</head>
<body>
	<h1>아이디 찾기 결과</h1>
	
	입력한 전화번호 : <%= request.getParameter("phonenumber") %><br>
	이메일 : ${ find }
	<hr>
	<form action="/login/signIn" method="get">
		<input type="submit" value="홈으로 돌아가기">
	</form>
</body>
</html>