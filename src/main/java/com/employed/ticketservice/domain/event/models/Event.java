package com.employed.ticketservice.domain.event.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private String description;

    @NonNull
    private Double price;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public String toString() {
        return String.format("%d %s %s %.2f %s", id, title, description, price, date);
    }
}
