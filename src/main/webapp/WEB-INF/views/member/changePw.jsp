<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<html>
	<head>
		
	 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<title>동아줄 : 회원정보수정</title>

		<link rel="stylesheet" href="/resources/css/changePw.css">
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cancle").on("click", function(){
				
				location.href = "/matching/swipe";
						    
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
		<div class="wrap">
			<div class="box">		
				<!-- ↑↑↑↑ 배경 추가 태그 ↑↑↑↑ -->

				<h1>비밀번호 변경</h1>

				<section id="container">
					<form action="/member/changePw" method="post">
						<div class="form-group has-feedback">
							<label class="control-label" for="email">E-mail</label>
							<input class="form-control" type="text" id="email" name="email" value="${member.email}" readonly="readonly"/>
						</div>
						<div class="form-group has-feedback">
							<label class="control-label" for="passwd">Password</label>
							<input class="form-control" type="password" id="passwd" name="passwd" />
						</div>
						<div class="form-group has-feedback">
							<label class="control-label" for="phonenumber">Phone-Number</label>
							<input class="form-control" type="text" id="phonenumber" name="phonenumber" value="${member.phonenumber}"/>
						</div>

						<div class="form-group has-feedback buttons">
							<button class="btn btn-success" type="submit" id="submit">회원정보수정</button>
							<button class="cancle btn btn-danger" type="button">취소</button>
						</div>
					</form>
				</section>

			</div>
		</div>
		
	</body>
	
</html>
 

 