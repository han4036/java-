package com.dongazul.myapp.handler;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
@Configuration
@EnableWebSocket

@NoArgsConstructor
@Log4j
public class WebSocketConfig extends Configurator 
	implements WebSocketConfigurer 
	{

	@Autowired
	private EchoHandler echoHandler;
	
	@Override
	public void registerWebSocketHandlers(
			WebSocketHandlerRegistry registry) {
		
		log.debug("registerWebSocketHandlers(registry) invoked.");
		
		registry.addHandler(echoHandler, "/echo").setAllowedOrigins("*").withSockJS()
		.setInterceptors(new HttpSessionHandshakeInterceptor()).
		setClientLibraryUrl("http://192.168.35.141/resources/sockjs.min.js");
		
	} // registerWebSocketHandlers
	
//	public void modifyHandShake(ServerEndpointConfig sec, HandshakeRequest req, HandshakeResponse res) {
//		log.debug("modifyHandShake(sec, req, res) invoked.");
//		
//		HttpSession session = (HttpSession) req.getHttpSession();
//		
//		if (session != null) {
//			sec.getUserProperties().put("PRIVATE_HTTP_SESSION", session);
//		}
//	} // modifyHandShake
	
} // end class
