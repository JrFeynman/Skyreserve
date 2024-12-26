package com.example.skyreserve.repository;

import com.example.skyreserve.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    Optional<Airport> findByCode(String code);
    // findByCity, findByCountry gibi ilave metotlar da ekleyebilirsiniz
}
