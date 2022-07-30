package com.employed.ticketservice.domain.user.services;


import com.employed.ticketservice.domain.core.ResourceCreationException;
import com.employed.ticketservice.domain.core.ResourceNotFoundException;
import com.employed.ticketservice.domain.user.models.User;
import com.employed.ticketservice.domain.user.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    private UserRepo userRepo;

    @Override
    public User create(User user) throws ResourceCreationException {
        Optional<User> optional = userRepo.findByEmail(user.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("Email already exist");
        return userRepo.save(user);
    }

    @Override
    public User getById(Long id) throws ResourceNotFoundException {
        User user = userRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No User with id: " + id));
        return user;
    }

    @Override
    public List<User> getByLastName(String lastName) {
        List<User> users = userRepo.findByLastName(lastName);
        return users;
    }

    @Override
    public User getByEmail(String email) throws ResourceNotFoundException {
        User user = userRepo.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("No User with email: " + email));
        return user;
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User update(Long id, User userDetail) throws ResourceNotFoundException {
        User user = getById(id);
        user.setLastName(userDetail.getLastName());
        user.setEmail(userDetail.getEmail());
        user = userRepo.save(user);
        return user;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        User user = getById(id);
        userRepo.delete(user);
    }
}
