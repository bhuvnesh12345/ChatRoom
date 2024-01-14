package com.bhuvnesh.chatroom;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class Config implements WebSocketMessageBrokerConfigurer {
    
	@Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
		//registry.addEndpoint("/server1");
        registry.addEndpoint("/server1").withSockJS();
    }
	
	@Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); // broker enables at this url
        registry.setApplicationDestinationPrefixes("/app"); // this is like base package name of our application means every endpoints will use this /app then use other endpoints of our application.
    }
}
