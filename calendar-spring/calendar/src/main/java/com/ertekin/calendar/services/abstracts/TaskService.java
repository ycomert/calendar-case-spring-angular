package com.ertekin.calendar.services.abstracts;

import com.ertekin.calendar.entities.Event;
import com.ertekin.calendar.entities.Task;
import com.ertekin.calendar.services.dtos.requests.AddTaskRequest;
import com.ertekin.calendar.services.dtos.responses.AddTaskResponse;

import java.util.List;

public interface TaskService {

    AddTaskResponse add(AddTaskRequest addTaskRequest);

    List<Task> getAllTasksByUserId(int userId);

}
