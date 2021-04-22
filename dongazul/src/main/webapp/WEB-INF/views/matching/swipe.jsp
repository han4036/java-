<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

	<script type="text/javascript">
		$(document).ready(function(){
			$("#signOut").on("click", function(){
				location.href="/login/signOut";
			})
			
			
		$("#memberUpdateBtn").on("click", function(){
			location.href="/member/changePw";
		})
			
		})
	</script>
<body>
	<h1>/WEB-INF/views/swipe.jsp</h1>
	<c:if test="${member != null}">
        <div>
           <p>${profile.nickname} &nbsp;님 환영합니다.</p>
	    <button id="memberUpdateBtn" type="button">회원정보수정</button>
	    <button id="signOut" type="button">로그아웃</button>
	    </div>
	    
	    
	    <form action="/member/dropOut" method="get">
			<input type="submit" value="회원탈퇴">
		</form>
	 	<c:if test="${ profile == null }">
			<form action="/profile/create" method="get">
			 	<input type="submit" value="프로필생성">
			</form>
		</c:if>
		
		<p>${ gender }</p>

     </c:if>
     
      
    
     
</body>
</html>