<%@page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>create.jsp</title>
</head>
<body>

	<h1>/WEB-ING/views/create.jsp</h1>
	
	<c:if test="${member != null}">
		<form action="/profile/create" method="post">
			
			<label for="email">이메일</label>
			<input type="text" id="email" name="email" value="${member.email}" readonly>
			<hr>
			<label for="nickname">닉네임</label>
			<input type="text" id="nickname" name="nickname">
			<hr>
			<label for="age">나이</label>
			<input type="text" id="age" name="age">
			<hr>
			<!-- <label for="gender">성별</label>
			<input type="text" id="gender" name="gender" placeholder="M or W" size="1"> -->
			<label for="male">남자</label>
			<input type="radio" id="male" name="gender" value="M">
			<label for="female">여자</label>
			<input type="radio" id="female" name="gender" value="W">
			<hr>
			<label for="zone">지역</label>
			<input type="text" id="zone" name="zone">
			<hr>
			<label for="introduce">자기소개</label>
			<textarea 
				name="introduce" 
				id="introduce" 
				cols="52" 
				rows="10"></textarea>
			<br>
			<br>
			<input type="submit" value="저장">	
		</form>
	</c:if>

</body>
</html>