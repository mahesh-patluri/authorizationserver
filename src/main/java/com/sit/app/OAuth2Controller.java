package com.sit.app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/oauth2")
public class OAuth2Controller {

//    @PostMapping("/token")
    public ResponseEntity<String> testTokenEndpoint() {
        return ResponseEntity.ok("Token endpoint is working");
    }
}
