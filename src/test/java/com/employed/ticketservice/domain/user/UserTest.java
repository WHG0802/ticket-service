package com.employed.ticketservice.domain.user;

import com.employed.ticketservice.domain.user.models.User;
import com.employed.ticketservice.domain.user.models.UserRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void userConstructorTest(){
        User user = new User("William", "Guy", "abc@123", UserRole.NON_ADMIN);
        user.setId(1L);
        String expected = "1 William Guy abc@123 NON_ADMIN";
        String actual = user.toString();
        Assertions.assertEquals(expected,actual);
    }
}
