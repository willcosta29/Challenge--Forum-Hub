package com.forum.hub.domain.login;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public record LoginForm(String email, String senha) {

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(email, senha);
    }
}

