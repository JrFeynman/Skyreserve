package com.example.skyreserve.repository;

import com.example.skyreserve.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    // Bir uçuşun tüm koltuklarını listelemek:
    List<Seat> findByFlightId(Long flightId);

    // Koltuk numarasına göre arama
    List<Seat> findByFlightIdAndSeatNumber(Long flightId, String seatNumber);
}
