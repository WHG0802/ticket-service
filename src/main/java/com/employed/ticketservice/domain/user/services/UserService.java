package com.employed.ticketservice.domain.user.services;

import com.employed.ticketservice.domain.core.ResourceCreationException;
import com.employed.ticketservice.domain.core.ResourceNotFoundException;
import com.employed.ticketservice.domain.user.models.User;

import java.util.List;

public interface UserService {
    User create(User user) throws ResourceCreationException;
    User getById(Long id) throws ResourceNotFoundException;
    List<User> getByLastName(String lastName) throws ResourceNotFoundException;
    User getByEmail(String email) throws ResourceNotFoundException;
    List<User> getAll();
    User update(Long id, User userDetail) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}
