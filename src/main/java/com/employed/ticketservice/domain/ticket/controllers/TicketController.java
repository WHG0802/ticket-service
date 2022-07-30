package com.employed.ticketservice.domain.ticket.controllers;

import com.employed.ticketservice.domain.ticket.services.TicketService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }



}
