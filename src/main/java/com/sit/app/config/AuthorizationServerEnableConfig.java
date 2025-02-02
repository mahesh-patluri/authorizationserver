package com.sit.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;

@Configuration
public class AuthorizationServerEnableConfig {

    @Bean
    public OAuth2AuthorizationServerConfigurer authorizationServerConfigurer() {
        return new OAuth2AuthorizationServerConfigurer();
    }
    
   
}