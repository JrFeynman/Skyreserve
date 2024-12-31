package com.example.skyreserve.repository;

import com.example.skyreserve.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);


    @Query(value = "SELECT create_user(:username, :password, :role)", nativeQuery = true)
    void createUser(@Param("username") String username, @Param("password") String password, @Param("role") String role);


}


