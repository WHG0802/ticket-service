package com.employed.ticketservice.domain.event.services;

import com.employed.ticketservice.domain.core.ResourceCreationException;
import com.employed.ticketservice.domain.core.ResourceNotFoundException;
import com.employed.ticketservice.domain.event.models.Event;

import java.util.List;

public interface EventService {
    Event create(Event event) throws ResourceCreationException;
    Event getById(Long id) throws ResourceNotFoundException;
    Event getByTitle(String title) throws ResourceNotFoundException;
    List<Event> getAll();
    Event update(Long id, Event eventDetail) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}
