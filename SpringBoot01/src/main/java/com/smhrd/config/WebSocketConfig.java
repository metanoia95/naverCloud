package com.smhrd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import lombok.RequiredArgsConstructor;

@EnableWebSocket // 웹소켓 사용 시작할 것이다. 
@RequiredArgsConstructor // 필요한 요소만 초기화하는 생성자.
@Configuration
public class WebSocketConfig implements WebSocketConfigurer{
	
	
	
	private final WebSocketHandler handler;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		
		// ws://localhost:8088/chat
		registry.addHandler(handler, "/chat/{room}")
				.setAllowedOrigins("*");
				// 외부 서버에서 연결을 허용
		
	}
	
	
	
	
}
