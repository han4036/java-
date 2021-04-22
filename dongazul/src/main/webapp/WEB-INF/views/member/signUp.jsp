  

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
	 	
	 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<title>회원가입</title>
				
			
		
	</head>
	
	
	<script type="text/javascript">
	$(document).ready(function(){
	      
	    $("#submit").on("click", function(){
	       if($("#email").val()==""){
	          alert("이메일을 입력해주세요.");
	          $('#submit').attr('disabled', true)
	          $("#email").focus();
	          return false;
	       } else {
	    	   $('#submit').attr('disabled', false);
	       }
	       
	       if($("#passwd").val()==""){
	          alert("비밀번호를 입력해주세요.");
	          $('#submit').attr('disabled', true);
	          $("#passwd").focus();
	          return false;
	       } else {
	    	   $('#submit').attr('disabled', false);
	       }
	       
	       if($("#phonenumber").val()==""){
	          alert("휴대폰 번호를 입력해주세요.");
	          $("#phonenumber").focus();
	          return false;
	       } 
	          
	    });
	    

	     $('#passwd').keyup(function(){
	          $('#chkNotice').html('');
	        });

	    $('#passwdCheck').keyup(function(){
			
	        if($('#passwd').val() != $('#passwdCheck').val() ){
	            $('#chkNotice').html('비밀번호 일치하지 않음<br><br>');
	            $('#chkNotice').css('color', '#f82a2aa3');
	            $('#submit').attr('disabled', true);
	        } else{
	            $('#chkNotice').html('비밀번호 일치함<br><br>');
	            $('#chkNotice').css('color', '#199894b3');
	            $('#submit').attr('disabled', false);
	        }
	        //   비밀번호 틀리면 회원가입 버튼 기능 제거
	    });
	 })

	 function fn_emailCheck() {
		$.ajax({
			url: "/member/emailCheck",
			type: "post",
			dataType: "json",
			data: {
				"email": $("#email").val()
			},
			success: function (data) {
				if ($("#email").val() == '' || $("#email").val() == 'undefined') return;
				if (data == 1) {
					alert("중복된 이메일입니다.");
					$('#submit').attr('disabled', false);
				} else if (data == 0) {
					$("#email").attr("value", "Y");
					alert("사용가능한 이메일입니다.");
				}
			}
		});
		
	}

	</script>
	
	<body>
	
		<section id="container">
			<form action="/member/signUp" method="POST">
				<div class="form-group has-feedback">
					<label class="control-label" for="email">이메일주소</label>
					<input class="form-control" type="email" id="email" name="email" />
					<button class="emailCheck" type="button" id="emailCheck" onclick="fn_emailCheck();" value="N">중복확인</button>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="passwd">패스워드</label>
					<input class="form-control" type="password" id="passwd" name="passwd" />
				</div>
					<div class="form-group has-feedback">
					<label class="control-label" for="passwdCheck">패스워드확인</label>
					<input class="form-control" type="password" id="passwdCheck" name="passwdCheck" />
					<span id="chkNotice"></span>
				</div>
				
				<div class="form-group has-feedback">
					<label class="control-label" for="phonenumber">휴대폰 번호</label>
					<input class="form-control" type="text" id="phonenumber" name="phonenumber" />
				</div>
				<div class="form-group has-feedback">
					<button class="btn btn-success" type="submit" id="submit">회원가입</button>
				</div>
			</form>
		</section>
		
	</body>
	
</html>