package com.ertekin.calendar.services.concretes;

import com.ertekin.calendar.entities.Task;
import com.ertekin.calendar.entities.User;
import com.ertekin.calendar.repositories.TaskRepository;
import com.ertekin.calendar.repositories.UserRepository;
import com.ertekin.calendar.services.abstracts.TaskService;
import com.ertekin.calendar.services.dtos.requests.AddTaskRequest;
import com.ertekin.calendar.services.dtos.responses.AddTaskResponse;
import com.ertekin.calendar.services.mappers.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    @Override
    public AddTaskResponse add(AddTaskRequest addTaskRequest) {
        Optional<User> user=userRepository.findById(addTaskRequest.getUserId());

        if (addTaskRequest.getStartDate().isAfter(addTaskRequest.getEndDate())) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }

        if (user.isPresent()){
            Task task= TaskMapper.INSTANCE.taskFromAddRequest(addTaskRequest);
            task=taskRepository.save(task);
            return TaskMapper.INSTANCE.taskToAddTaskResponse(task);
        }
        else{
            throw new RuntimeException("User ID Not Found");
        }
    }

    @Override
    public List<Task> getAllTasksByUserId(int userId) {
        return taskRepository.findAllByUserId(userId);
    }
}
