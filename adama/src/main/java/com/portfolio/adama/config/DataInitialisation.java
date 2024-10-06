package com.portfolio.adama.config;

import com.portfolio.adama.entities.User;
import com.portfolio.adama.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitialisation implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${spring.application.user.default.username}")
    private String username;
    @Value("${spring.application.user.default.password}")
    private String password;

    @Override
    public void run(String... args) throws Exception {
        User user = userRepository.findByEmail(username).orElse(null);
        if (user == null) {
            user = new User();
            user.setEmail(username);
            user.setPassword(passwordEncoder.encode(password));
            this.userRepository.save(user);
            log.info("Admin saved");
        }
    }
}
