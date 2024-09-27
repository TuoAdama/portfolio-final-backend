package com.portfolio.adama.services;

import com.portfolio.adama.entities.UserAddressIP;
import com.portfolio.adama.repositories.UserAddressIPRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserAddressIPService {
    private final UserAddressIPRepository userAddressIPRepository;

    public UserAddressIPService(UserAddressIPRepository userAddressIPRepository) {
        this.userAddressIPRepository = userAddressIPRepository;
    }

    public UserAddressIP create(String ip) {
        UserAddressIP userAddressIP = new UserAddressIP();
        userAddressIP.setIp(ip);
        userAddressIP.setCreatedAt(LocalDateTime.now());
        return userAddressIPRepository.save(userAddressIP);
    }

    public List<UserAddressIP> getAll() {
        return this.userAddressIPRepository.findAll();
    }
}
