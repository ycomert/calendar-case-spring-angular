package com.ertekin.calendar.services.abstracts;

import com.ertekin.calendar.entities.Event;
import com.ertekin.calendar.services.dtos.requests.AddEventRequest;
import com.ertekin.calendar.services.dtos.responses.AddEventResponse;

import java.util.List;

public interface EventService {
    AddEventResponse add(AddEventRequest addEventRequest);
    List<Event> getAllEventsByUserId(int userId);
}
