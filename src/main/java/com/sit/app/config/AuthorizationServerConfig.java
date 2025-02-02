package com.sit.app.config;

import java.time.Duration;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

@Configuration
public class AuthorizationServerConfig {
	
	@Bean
	public RegisteredClientRepository registeredClientRepository() {
	    RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
	        .clientId("client-id") // Must match the ID in your request
	        .clientSecret("{noop}client-secret") // Ensure this matches your request
	        .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
	        .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
	        .scope("read")
	        .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
	        .tokenSettings(TokenSettings.builder()
	            .accessTokenTimeToLive(Duration.ofMinutes(30))
	            .refreshTokenTimeToLive(Duration.ofHours(1))
	            .build())
	        .build();

	    return new InMemoryRegisteredClientRepository(registeredClient);
	}


}
