package com.employed.ticketservice.domain.ticket.services;

import com.employed.ticketservice.domain.core.ResourceNotFoundException;
import com.employed.ticketservice.domain.ticket.models.Ticket;

import java.util.List;

public interface TicketService {
    Ticket create(Ticket ticket);
    Ticket getById(Long id) throws ResourceNotFoundException;
    List<Ticket> getByUser(Long id) throws ResourceNotFoundException;
    List<Ticket> getByEvent(Long id) throws ResourceNotFoundException;
    Ticket update(Long id, Ticket ticketDetail) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}
