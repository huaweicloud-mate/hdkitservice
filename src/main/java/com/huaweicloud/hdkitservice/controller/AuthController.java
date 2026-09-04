package com.huaweicloud.hdkitservice.controller;

import com.huaweicloud.hdkitservice.model.LoginRequest;
import com.huaweicloud.hdkitservice.model.LoginResponse;
import com.huaweicloud.hdkitservice.service.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/developer/server/auth")
public class AuthController {

    @Value("${hdkit.auth.admin-username}")
    private String adminUsername;

    @Value("${hdkit.auth.admin-password}")
    private String adminPassword;

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        if (request.username() == null || request.password() == null
                || !adminUsername.equals(request.username())
                || !adminPassword.equals(request.password())) {
            throw new RuntimeException("用户名或密码错误");
        }
        String token = jwtService.generateToken(adminUsername);
        return new LoginResponse(token, adminUsername, 24);
    }
}
