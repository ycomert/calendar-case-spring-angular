package com.ertekin.calendar.services.dtos.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddEventRequest {
    @NotNull(message = "ID cannot be null")
    @Min(value = 1, message = "ID must be a positive number")
    private int userId;

    @NotNull(message = "Tittle Cannot Be Empty")
    private String tittle;

    @NotNull(message = "Start Date Cannot Be Empty")
    private LocalDate startDate;

    @NotNull(message = "End Date Cannot Be Empty")
    private LocalDate endDate;
}
