package com.employed.ticketservice.domain.user.models;

import com.employed.ticketservice.domain.ticket.models.Ticket;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private UserRole role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Ticket> tickets;

    public String toString(){
        return String.format("%d %s %s %s %s",id, firstName, lastName, email, role);
    }

}
