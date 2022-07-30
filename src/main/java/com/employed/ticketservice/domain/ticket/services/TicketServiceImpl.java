package com.employed.ticketservice.domain.ticket.services;

import com.employed.ticketservice.domain.core.ResourceNotFoundException;
import com.employed.ticketservice.domain.ticket.models.Ticket;
import com.employed.ticketservice.domain.ticket.repository.TicketRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TicketServiceImpl implements TicketService{

    private TicketRepo ticketRepo;

    @Override
    public Ticket create(Ticket ticket) {
        return ticketRepo.save(ticket);
    }

    @Override
    public Ticket getById(Long id) throws ResourceNotFoundException {
        Ticket ticket = ticketRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No Ticket with id: " + id));
        return ticket;
    }

    @Override
    public List<Ticket> getByUser(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public List<Ticket> getByEvent(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Ticket update(Long id, Ticket ticketDetail) throws ResourceNotFoundException {
        Ticket ticket = getById(id);
        ticket.setUser(ticketDetail.getUser());
        ticket.setEvent(ticketDetail.getEvent());
        ticket = ticketRepo.save(ticket);
        return ticket;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Ticket ticket = getById(id);
        ticketRepo.delete(ticket);
    }
}
