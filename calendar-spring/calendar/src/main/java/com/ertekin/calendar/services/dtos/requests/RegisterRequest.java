package com.ertekin.calendar.services.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotNull(message = "Username Cannot Be Empty")
    private String name;

    @NotNull(message = "Email Cannot Be Empty")
    private String email;

    @NotNull(message = "Password Cannot Be Empty")
    private String password;

}
