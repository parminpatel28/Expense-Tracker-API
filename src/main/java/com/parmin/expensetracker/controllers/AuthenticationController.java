package com.parmin.expensetracker.controllers;

import com.parmin.expensetracker.configurations.JwtAuthenticationFilter;
import com.parmin.expensetracker.dto.LoginUserDto;
import com.parmin.expensetracker.model.User;
import com.parmin.expensetracker.response.LoginResponse;
import com.parmin.expensetracker.services.AuthenticationService;
import com.parmin.expensetracker.services.JwtService;
import com.sun.net.httpserver.HttpContext;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.parmin.expensetracker.dto.RegisterUserDto;
@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;


    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody RegisterUserDto registerUserDto) {

        User registerUser = authenticationService.signUp(registerUserDto);

        return ResponseEntity.ok(registerUser);

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserDto loginUserDto) {

        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiryTime(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

}
