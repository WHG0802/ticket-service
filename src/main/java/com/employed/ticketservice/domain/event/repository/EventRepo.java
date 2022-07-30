package com.employed.ticketservice.domain.event.repository;

import com.employed.ticketservice.domain.event.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EventRepo extends JpaRepository<Event,Long> {
    Optional<Event> findByTitle(String title);
}
