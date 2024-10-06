package com.portfolio.adama.controllers;


import com.portfolio.adama.requests.TokenRequest;
import com.portfolio.adama.responses.TokenResponse;
import com.portfolio.adama.services.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/token")
public class TokenController {

    private final TokenService tokenService;

    @GetMapping
    public @ResponseBody ResponseEntity<TokenResponse> getToken(@RequestBody TokenRequest tokenRequest) {
        TokenResponse response = this.tokenService.getTokenResponse(tokenRequest);
        if(response == null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
