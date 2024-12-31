package com.example.skyreserve.repository;

import com.example.skyreserve.entity.Airline;
import com.example.skyreserve.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AirlineRepository extends JpaRepository<Airline, Long> {
    Optional<Airline> findByCode(String code);
    Optional<Airline> findByName(String name);
}
