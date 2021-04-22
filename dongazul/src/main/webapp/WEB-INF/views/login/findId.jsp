<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.3.2/jquery-migrate.min.js"></script>


<title>findId.jsp</title>
<%-- <script type="text/javascript" language="javascript">
	$("#findIdResult").click(function(){
		 $.ajax({
	        type:"POST",
	        url:"/login/findIdResult",
	        data : { phonenumber : <%= request.getParameter("phonenumber") %> },
	        success: function(){
	            alert("email : " + email);
	        },
	        error: function() {
	            alert("전화번호를 확인하세요");
	        }  
	    });
	})
	

</script> --%>
</head>
<body>
	<h1>이메일 찾기 화면</h1>
	<h1>/WEB-INF/views/login/findId.jsp</h1>
	<form action="/login/findIdResult" method="post">
		<input type="number" id="phonenumber" name="phonenumber">
		<input type="submit" value="이메일찾기">
	</form>
	<!-- <button id="findIdResult">이메일 찾기</button> -->
</body>
</html>