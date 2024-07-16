package com.ertekin.calendar.repositories;

import com.ertekin.calendar.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Integer> {
    List<Event> findAllByUserId(int userId);
}
