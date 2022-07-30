package com.employed.ticketservice.domain.ticket.models;

import com.employed.ticketservice.domain.user.models.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jdk.jfr.Event;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne
    @JsonBackReference
    private User user;

    @NonNull
    @ManyToOne
    private Event event;
}
