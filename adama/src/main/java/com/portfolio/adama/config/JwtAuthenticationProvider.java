package com.portfolio.adama.config;

import com.portfolio.adama.entities.Token;
import com.portfolio.adama.entities.User;
import com.portfolio.adama.repositories.TokenRepository;
import com.portfolio.adama.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final JwtService jwtService;
    private final TokenRepository tokenRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String credentialsToken = (String) authentication.getCredentials();
        Token token  = this.tokenRepository.findOneByToken(credentialsToken).orElse(null);
        if(token == null) {
            return null;
        }
        User user = token.getUser();
        if (!this.jwtService.isTokenValid(token.getToken(), user)) {
            return null;
        }
        return new JwtAuthenticationToken(user, token.getToken());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
