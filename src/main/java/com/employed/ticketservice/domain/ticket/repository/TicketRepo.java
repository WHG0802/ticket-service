package com.employed.ticketservice.domain.ticket.repository;

import com.employed.ticketservice.domain.ticket.models.Ticket;
import com.employed.ticketservice.domain.user.models.User;
import jdk.jfr.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepo extends JpaRepository<Ticket,Long> {
    List<Ticket> findByUser(User user);
    List<Ticket> findByEvent(Event event);
}
