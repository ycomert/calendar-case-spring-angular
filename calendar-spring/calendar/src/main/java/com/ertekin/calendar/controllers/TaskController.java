package com.ertekin.calendar.controllers;

import com.ertekin.calendar.entities.Event;
import com.ertekin.calendar.entities.Task;
import com.ertekin.calendar.services.abstracts.TaskService;
import com.ertekin.calendar.services.dtos.requests.AddTaskRequest;
import com.ertekin.calendar.services.dtos.responses.AddTaskResponse;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("createtask")
    @ResponseStatus(HttpStatus.CREATED)
    public AddTaskResponse add(@Valid @RequestBody AddTaskRequest request){
        return taskService.add(request);
    }


    @GetMapping("gettask/{userId}")
    public List<Task> getAllTasks(@PathVariable int userId) {
        return taskService.getAllTasksByUserId(userId);
    }

}
