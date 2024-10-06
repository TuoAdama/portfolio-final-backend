package com.portfolio.adama.services;

import com.portfolio.adama.entities.Token;
import com.portfolio.adama.entities.User;
import com.portfolio.adama.repositories.TokenRepository;
import com.portfolio.adama.repositories.UserRepository;
import com.portfolio.adama.requests.TokenRequest;
import com.portfolio.adama.responses.TokenResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    public TokenResponse getTokenResponse(TokenRequest tokenRequest) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(tokenRequest.username()).orElse(null);
        if (user == null || !passwordEncoder.matches(tokenRequest.password(), user.getPassword())) {
            return null;
        }
        if(!user.getTokens().isEmpty()){
            this.tokenRepository.deleteAll(user.getTokens());
        }
        String tokenRaw = jwtService.generateToken(user);
        Token token = new Token();
        token.setToken(tokenRaw);
        token.setUser(user);
        token.setExpiryDate(jwtService.extractExpiredDate(tokenRaw));
        this.tokenRepository.save(token);
        return new TokenResponse(tokenRaw);
    }

}
