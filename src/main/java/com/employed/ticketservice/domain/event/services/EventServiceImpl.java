package com.employed.ticketservice.domain.event.services;


import com.employed.ticketservice.domain.core.ResourceCreationException;
import com.employed.ticketservice.domain.core.ResourceNotFoundException;
import com.employed.ticketservice.domain.event.models.Event;
import com.employed.ticketservice.domain.event.repository.EventRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EventServiceImpl implements EventService {

    private EventRepo eventRepo;

    @Override
    public Event create(Event event) throws ResourceCreationException {
        Optional<Event> optional = eventRepo.findByTitle(event.getTitle());
        if(optional.isPresent())
            throw new ResourceCreationException("Title already exist");
        return eventRepo.save(event);
    }

    @Override
    public Event getById(Long id) throws ResourceNotFoundException {
        Event event = eventRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No Event with id: " + id));
        return event;
    }

    @Override
    public Event getByTitle(String title) throws ResourceNotFoundException {
        Event event = eventRepo.findByTitle(title)
                .orElseThrow(()->new ResourceNotFoundException("No Event with title: " + title));
        return event;
    }

    @Override
    public List<Event> getAll() {
        return eventRepo.findAll();
    }

    @Override
    public Event update(Long id, Event eventDetail) throws ResourceNotFoundException {
        Event event = getById(id);
        event.setTitle(eventDetail.getTitle());
        event.setPrice(eventDetail.getPrice());
        event = eventRepo.save(event);
        return event;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Event event = getById(id);
        eventRepo.delete(event);
    }
}
