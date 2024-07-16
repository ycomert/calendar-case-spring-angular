package com.ertekin.calendar.services.abstracts;

import com.ertekin.calendar.services.dtos.requests.LoginRequest;
import com.ertekin.calendar.services.dtos.requests.RegisterRequest;
import com.ertekin.calendar.services.dtos.responses.AddTaskResponse;

public interface AuthService {

    void register(RegisterRequest registerRequest);

    String login(LoginRequest loginRequest);

}
