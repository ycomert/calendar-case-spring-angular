package com.ertekin.calendar.controllers;

import com.ertekin.calendar.services.abstracts.AuthService;
import com.ertekin.calendar.services.dtos.requests.LoginRequest;
import com.ertekin.calendar.services.dtos.requests.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public String register(@Valid @RequestBody RegisterRequest request){
    authService.register(request);
        return "User created successfully";
    }

    @PostMapping("login")
    @ResponseStatus(HttpStatus.CREATED)
    public String login(@RequestBody LoginRequest request){
    return authService.login(request);
    }

}
