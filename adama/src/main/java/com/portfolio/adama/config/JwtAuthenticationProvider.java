package com.portfolio.adama.config;

import com.portfolio.adama.entities.Token;
import com.portfolio.adama.entities.User;
import com.portfolio.adama.repositories.TokenRepository;
import com.portfolio.adama.services.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final JwtService jwtService;
    private final TokenRepository tokenRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String tokenRaw = (String) authentication.getCredentials();
        Token token  = this.tokenRepository.findOneByToken(tokenRaw).orElse(null);
        if(token == null) {
            return null;
        }
        User user = token.getUser();
        if (!this.jwtService.isTokenValid(tokenRaw, user)) {
            return null;
        }
        return new JwtAuthenticationToken(user, token.getToken());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
