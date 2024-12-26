package com.example.skyreserve.repository;

import com.example.skyreserve.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirlineRepository extends JpaRepository<Airline, Long> {
    Optional<Airline> findByCode(String code);
    // findByName, findByCode gibi metotlar da ekleyebilirsiniz
}
