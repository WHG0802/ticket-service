package com.employed.ticketservice.domain.user.repository;

import com.employed.ticketservice.domain.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    List<User> findByLastName(String lastName);
}
