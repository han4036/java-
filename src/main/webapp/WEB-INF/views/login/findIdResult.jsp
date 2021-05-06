<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>findIdResult.jsp</title>
<link rel="stylesheet" href="/resources/css/findIdResult.css">
</head>
<body>

	<div class="wrap">
		<div class="box">
			<h1>이메일</h1>
			
			<div class="result">
			
			${FIND} 
			</div>
			<hr>
			<form action="/" method="get">
				<input type="submit" value="홈으로 돌아가기" class="back">
			</form>
		</div>
	</div>
</body>
</html>