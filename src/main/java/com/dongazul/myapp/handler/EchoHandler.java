package com.dongazul.myapp.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@NoArgsConstructor
@Log4j
public class EchoHandler extends TextWebSocketHandler{
	
	
    //세션 리스트
    private List<WebSocketSession> sessionList = new ArrayList<>();
    
    //클라이언트가 연결 되었을 때 실행
    @Override
    public void afterConnectionEstablished(
    			WebSocketSession session
    			) throws Exception {
    	
    	log.debug("afterConnectionEstablished(session) invoked.");
    	
        sessionList.add(session);
        
    } // afterConnectionEstablished

    //클라이언트가 웹소켓 서버로 메시지를 전송했을 때 실행
    @Override
    protected void handleTextMessage(
    			WebSocketSession session,
    			TextMessage message
    			) throws Exception {
    	
    	log.debug("handleTextMessage(session, message) invoked.");
    	 Map<String,Object> map = session.getAttributes();

    	String email = (String) map.get("member.email");
    	
    	System.out.println("\t+ email: " + email);
    	
        //모든 유저에게 메시지 출력
        for(WebSocketSession sess : sessionList){
        	
            sess.sendMessage(new TextMessage(session.getId()+" : "+message.getPayload()));
            
        } // enhanced for
        
    } // handleTextMessage

    //클라이언트 연결을 끊었을 때 실행
    @Override
    public void afterConnectionClosed(
    		WebSocketSession session,
    		CloseStatus status
    		) throws Exception {
    	
    	log.debug("afterConnectionClosed(session, status) invoked.");
    	
        sessionList.remove(session);
    } // afterConnectionClosed

} // end class
