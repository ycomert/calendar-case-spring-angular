package com.ertekin.calendar.repositories;

import com.ertekin.calendar.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Integer > {
    List<Task> findAllByUserId(int userId);
}
