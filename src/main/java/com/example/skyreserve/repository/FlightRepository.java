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

    // Özel sorgu: Origin ve Destination airport koduna ve departure time sonrası uçuşlara göre arama
    @Query("SELECT f FROM Flight f WHERE f.originAirport.code = :originCode AND f.destinationAirport.code = :destCode AND f.departureTime > :departureTime")
    List<Flight> searchFlights(@Param("originCode") String originCode,
                               @Param("destCode") String destCode,
                               @Param("departureTime") LocalDateTime departureTime);
}
