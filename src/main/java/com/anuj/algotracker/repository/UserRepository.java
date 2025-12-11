package com.anuj.algotracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anuj.algotracker.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
