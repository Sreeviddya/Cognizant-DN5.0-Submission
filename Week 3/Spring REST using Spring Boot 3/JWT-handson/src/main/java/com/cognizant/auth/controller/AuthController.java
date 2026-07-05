package com.cognizant.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.auth.model.AuthResponse;
import com.cognizant.auth.security.JwtUtil;

@RestController
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public AuthResponse authenticate(@AuthenticationPrincipal UserDetails userDetails) {
        LOGGER.info("Start");
        String token = jwtUtil.generateToken(userDetails.getUsername());
        LOGGER.info("End");
        return new AuthResponse(token);
    }
}
