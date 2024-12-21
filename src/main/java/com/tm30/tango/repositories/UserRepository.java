package com.tm30.tango.repositories;

import com.tm30.tango.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String username);
    Optional<User> findByPhoneNumber(String phoneNumber);
}
