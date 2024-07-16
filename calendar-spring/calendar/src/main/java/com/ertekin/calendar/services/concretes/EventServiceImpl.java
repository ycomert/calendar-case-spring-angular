package com.ertekin.calendar.services.concretes;

import com.ertekin.calendar.entities.Event;
import com.ertekin.calendar.entities.User;
import com.ertekin.calendar.repositories.EventRepository;
import com.ertekin.calendar.repositories.UserRepository;
import com.ertekin.calendar.services.abstracts.EventService;
import com.ertekin.calendar.services.dtos.requests.AddEventRequest;
import com.ertekin.calendar.services.dtos.responses.AddEventResponse;
import com.ertekin.calendar.services.mappers.EventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;


    @Override
    public AddEventResponse add(AddEventRequest addEventRequest) {
        Optional<User> user=userRepository.findById(addEventRequest.getUserId());

        if (addEventRequest.getStartDate().isAfter(addEventRequest.getEndDate())) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }

        if(user.isPresent()){
            Event event= EventMapper.INSTANCE.eventFromAddRequest(addEventRequest);
            event=eventRepository.save(event);
            return EventMapper.INSTANCE.eventToAddTaskResponse(event);
        }
        else{
            throw new RuntimeException("User ID Not Found!");
        }
    }

    @Override
    public List<Event> getAllEventsByUserId(int userId) {
        return eventRepository.findAllByUserId(userId);
    }
}
