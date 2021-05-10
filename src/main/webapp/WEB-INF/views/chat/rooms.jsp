<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.1/sockjs.min.js"></script>
	<!-- <script>

		$("#button-send").on("click", function (e) {
			sendMessage();
			$('#message').val('')
		});
		
		var sock = new SockJS('http://localhost:8080/rooms');
		sock.onmessage = onMessage;
		sock.onclose = onClose;
		sock.onopen = onOpen;

		function sendMessage() {
			sock.send($("message").val());
		}

		// 서버에서 메시지를 받았을때
		function onMessage(msg) {
			
			var data = message.data;
			var sessionId = null;	// 데이터를 보낸사람
			var message = null;

			var arr = data.split(":");

			for(var i=0; i<arr.length; i++){
				console.log('arr[' + i + ']: ' + arr[i]);
			}

			var cur_session = '${email}';
			console.log("cur_session : " + cur_session);

			sessionId = arr[0];
			message = arr[1];

			// // 로그인한 클라이언트와 타 클라이언트를 분류하기 위함
			// if(sessionId == cur_session) {

			// 	var str = "<div"
			// }
		}

		// 채팅창에서 나갔을때
		function onClose(evt) {
			
			var user = '${profile.nickname}';
			var str = user + "님이 퇴장하셨습니다.";

			$('#chat').append(str);
		}

		// 채팅창에 들어왔을때
		function onOpen(evt) {
			
			var user = '${profile.nickname}';
			var str = user + "님이 입장하셨습니다";

			$('#chat').append(str);
		}


	</script> -->
</head>
<body>
	<form action="/matching/swipe" method="get">
            <input type="submit" value="←">
    </form>
    
	<form id="chatForm">
	
		<input type="text" id="message"/>
		<button>send</button>

	</form>
	
	<div id="chat">
		${ info }&nbsp님이 입장하셨습니다.<br>
	</div>
	<script>
		$(document).ready(function(){
			$("#chatForm").submit(function(event){
				event.preventDefault();
				sock.send($("#message").val());
				$("#message").val('').focus();
			}); // charForm
		});
		
		var sock = new SockJS("http://192.168.35.141:8080/echo");
		sock.onmessage = function(e){
			$("#chat").append("&nbsp"+e.data + "<br/>");
		} // sock
		
		sock.onclose = function(){
			$("#chat").append("연결 종료");
		} // onclose
		
	</script>
	
	  
</body>
</html>