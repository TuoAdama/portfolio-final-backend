package com.portfolio.adama.config;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final String principal;
    private final String credentials;

    JwtAuthenticationToken(String jwtToken) {
        super(null);
        this.principal = null;
        this.credentials = jwtToken;
    }

    public JwtAuthenticationToken(UserDetails userDetails, String credentials) {
        super(null);
        this.principal = userDetails.getUsername();
        this.credentials = credentials;
        this.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }
}
