package com.expertaart.refactorapp.config.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.expertaart.refactorapp.services.push.properties.WebSocketEndpointProperties;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Autowired
	private WebSocketEndpointProperties webSocketEndpointProperties;
	
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker(webSocketEndpointProperties.getBrokerPath());
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
    	registry.addEndpoint(webSocketEndpointProperties.getEndpointIOS()).withSockJS();;
    	registry.addEndpoint(webSocketEndpointProperties.getEndpointAndroid()).withSockJS();;
        
    }
 

}