package com.example.skyreserve.repository;

import com.example.skyreserve.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUserId(Long userId);
    List<Reservation> findByFlightId(Long flightId);
    List<Reservation> findBySeatId(Long seatId);
    List<Reservation> findByStatus(String status); // Yeni ekleme: Duruma göre sorgulama
}
