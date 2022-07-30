package com.employed.ticketservice.domain.user;

import com.employed.ticketservice.domain.event.models.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EventTest {

    @Test
    public void eventConstructorTest(){
        Event event = new Event("Football Game", "Eagles vs. Cowboys", 89.99);
        event.setId(1L);
        String expected = "1 Football Game Eagles vs. Cowboys 89.99 null";
        String actual = event.toString();
        Assertions.assertEquals(expected,actual);
    }
}
