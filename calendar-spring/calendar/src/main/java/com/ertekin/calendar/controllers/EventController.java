package com.ertekin.calendar.controllers;

import com.ertekin.calendar.entities.Event;
import com.ertekin.calendar.services.abstracts.EventService;
import com.ertekin.calendar.services.dtos.requests.AddEventRequest;
import com.ertekin.calendar.services.dtos.responses.AddEventResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping("createevent")
    @ResponseStatus(HttpStatus.CREATED)
    public AddEventResponse add(@Valid @RequestBody AddEventRequest request){
        return eventService.add(request);
    }


    @GetMapping("getevents/{userId}")
    public List<Event> getAllEvents(@PathVariable int userId) {
        return eventService.getAllEventsByUserId(userId);
    }

}
