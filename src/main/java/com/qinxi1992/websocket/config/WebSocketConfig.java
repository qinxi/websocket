package com.qinxi1992.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.user.MultiServerUserRegistry;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.messaging.simp.user.UserSessionRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
       /* registry.enableStompBrokerRelay("/topic", "/queue").setUserRegistryBroadcast("/topic/simp-user-registry")
        .setUserDestinationBroadcast("/topic/unresolved-user-destination");*/
        registry.enableSimpleBroker("/topic", "/queue");
        registry.setApplicationDestinationPrefixes("/app");
    }
/*
    @Bean
    public SimpUserRegistry userSessionRegistry(RedisUserSessionRegistry redisUserSessionRegistry) {
        return new MultiServerUserRegistry(redisUserSessionRegistry);
    }*/

  /*  @Bean
    public UserSessionRegistry userSessionRegistry() {
        return new RedisUserSessionRegistry(redisConnectionFactory);
    }*/

}
