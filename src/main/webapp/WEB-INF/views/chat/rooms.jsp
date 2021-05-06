<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="/resources/sockjs.min.js"></script>
</head>
<body>
	<form action="/matching/swipe" method="get">
            <input type="submit" value="←">
    </form>
    
	<form id="chatForm">
		<input type="text" id="message"/>
		<button>send</button>
	</form>
	
	<div id="chat"></div>
	<script>
		$(document).ready(function(){
			$("#chatForm").submit(function(event){
				event.preventDefault();
				sock.send($("#message").val());
				$("#message").val('').focus();
			}); // charForm
		});
		
		var sock = new SockJS("/echo");
		sock.onmessage = function(e){
			$("#chat").append(e.data + "<br/>");
		} // sock
		
		sock.onclose = function(){
			$("#chat").append("연결 종료");
		} // onclose
		
	</script>
	
	  
</body>
</html>