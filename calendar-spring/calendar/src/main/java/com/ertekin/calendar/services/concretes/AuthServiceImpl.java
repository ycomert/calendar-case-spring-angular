package com.ertekin.calendar.services.concretes;

import com.ertekin.calendar.core.services.JwtService;
import com.ertekin.calendar.entities.User;
import com.ertekin.calendar.repositories.UserRepository;
import com.ertekin.calendar.services.abstracts.AuthService;
import com.ertekin.calendar.services.dtos.requests.LoginRequest;
import com.ertekin.calendar.services.dtos.requests.RegisterRequest;
import com.ertekin.calendar.services.mappers.AuthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public void register(RegisterRequest registerRequest) {

        User user= AuthMapper.INSTANCE.userFromRegisterRequest(registerRequest);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userRepository.save(user);
    }

    @Override
    public String login(LoginRequest loginRequest) {
        User user=userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new RuntimeException("Email Not Found"));
        Authentication authentication=
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
        if(!authentication.isAuthenticated()){
            throw new RuntimeException("Email or Password is Incorrect");
        }
        Map<String,Object> extraClaims=new HashMap<>();
        extraClaims.put("UserId",user.getId());
        return jwtService.generateToken(user.getUsername(),extraClaims);
    }
}
