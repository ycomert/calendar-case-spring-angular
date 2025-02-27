package com.ertekin.calendar.services.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddEventResponse {

    private int userId;

    private String tittle;

    private LocalDate startDate;

    private LocalDate endDate;

}
