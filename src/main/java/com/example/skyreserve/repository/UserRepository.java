package com.example.skyreserve.repository;

import com.example.skyreserve.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    // Rol bazlı kullanıcıları listelemek isterseniz:
    // List<User> findByRole(String role);
}
