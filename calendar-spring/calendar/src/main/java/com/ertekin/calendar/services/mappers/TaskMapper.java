package com.ertekin.calendar.services.mappers;

import com.ertekin.calendar.entities.Task;
import com.ertekin.calendar.services.dtos.requests.AddTaskRequest;
import com.ertekin.calendar.services.dtos.responses.AddTaskResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE= Mappers.getMapper(TaskMapper.class);

    @Mapping(source="userId",target="user.id")
    Task taskFromAddRequest(AddTaskRequest addTaskRequest);

    @Mapping(source = "user.id", target = "userId")
    AddTaskResponse taskToAddTaskResponse(Task task);

}
