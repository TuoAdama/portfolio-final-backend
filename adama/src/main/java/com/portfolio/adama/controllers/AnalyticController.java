package com.portfolio.adama.controllers;

import com.portfolio.adama.entities.UserAddressIP;
import com.portfolio.adama.services.UserAddressIPService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticController {

    private final UserAddressIPService userAddressIPService;

    public AnalyticController(
            UserAddressIPService userAddressIPService
    ) {
        this.userAddressIPService = userAddressIPService;
    }

    @PostMapping
    public @ResponseBody void getAnalytics(HttpServletRequest request) {
        this.userAddressIPService.create(request.getRemoteAddr());
    }

    @GetMapping
    public @ResponseBody List<UserAddressIP> getAnalytics() {
        return this.userAddressIPService.getAll();
    }

}
