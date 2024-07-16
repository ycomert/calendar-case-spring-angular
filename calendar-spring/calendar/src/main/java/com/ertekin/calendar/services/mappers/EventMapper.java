package com.ertekin.calendar.services.mappers;

import com.ertekin.calendar.entities.Event;
import com.ertekin.calendar.services.dtos.requests.AddEventRequest;
import com.ertekin.calendar.services.dtos.responses.AddEventResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventMapper {
    EventMapper INSTANCE= Mappers.getMapper(EventMapper.class);


    @Mapping(source="userId",target="user.id")
    Event eventFromAddRequest(AddEventRequest addEventRequest);


    @Mapping(source="user.id",target="userId")
    AddEventResponse eventToAddTaskResponse(Event event);
}
