package com.example.skyreserve.repository;

import com.example.skyreserve.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    Optional<Flight> findByFlightNumber(String flightNumber);
    Optional<Flight> findById(Long id);
    @Query("SELECT f FROM Flight f WHERE LOWER(f.originAirport.city) = LOWER(:originCity) AND LOWER(f.destinationAirport.city) = LOWER(:destinationCity)")
    List<Flight> searchByCities(String originCity, String destinationCity);
}


