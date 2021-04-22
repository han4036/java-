<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		
	 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<title>회원가입</title>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cancle").on("click", function(){
				
				location.href = "/login/signIn";
						    
			})
		
			$("#submit").on("click", function(){
				if($("#passwd").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#phonenumber").focus();
					return false;
				}
				if($("#phonenumber").val()==""){
					alert("전화번호를 입력해주세요.");
					$("#phonenumber").focus();
					return false;
				}
			});
			
				
			
		})
	</script>
	<body>
		<section id="container">
			<form action="/member/changePw" method="post">
				<div class="form-group has-feedback">
					<label class="control-label" for="email">이메일</label>
					<input class="form-control" type="text" id="email" name="email" value="${member.email}" readonly="readonly"/>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="passwd">패스워드</label>
					<input class="form-control" type="password" id="passwd" name="passwd" />
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="phonenumber">휴대폰번호</label>
					<input class="form-control" type="text" id="phonenumber" name="phonenumber" value="${member.phonenumber}"/>
				</div>
				<div class="form-group has-feedback">
					<button class="btn btn-success" type="submit" id="submit">회원정보수정</button>
					<button class="cancle btn btn-danger" type="button">취소</button>
				</div>
			</form>
		</section>
		
	</body>
	
</html>
 

 