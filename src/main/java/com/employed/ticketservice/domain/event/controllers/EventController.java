package com.employed.ticketservice.domain.event.controllers;


import com.employed.ticketservice.domain.event.models.Event;
import com.employed.ticketservice.domain.event.services.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    private EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAll(){
        List<Event> events = eventService.getAll();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event event){
        event = eventService.create(event);
        return new ResponseEntity<>(event, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Event> getById(@PathVariable("id") Long id){
        Event event = eventService.getById(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<Event> getByTitle(@RequestParam String title){
        Event event = eventService.getByTitle(title);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Event> update(@PathVariable("id") Long id, @RequestBody Event eventDetail){
        eventDetail = eventService.update(id,eventDetail);
        return new ResponseEntity<>(eventDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        eventService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
