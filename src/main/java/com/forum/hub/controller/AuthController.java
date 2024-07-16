package com.forum.hub.controller;

import com.forum.hub.security.AuthData;
import com.forum.hub.security.TokenData;
import com.forum.hub.security.TokenService;
import com.forum.hub.model.AuthUser;
import com.forum.hub.repository.AuthRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    AuthRepository authRepository;

    @Autowired
    TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenData> auth(@RequestBody @Valid AuthData authData) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(authData.username(), authData.password());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((AuthUser) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenData(tokenJWT));
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
