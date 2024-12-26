package com.example.skyreserve.repository;

import com.example.skyreserve.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Belirli bir kullanıcıya ait rezervasyonları bulma
    List<Reservation> findByUserId(Long userId);

    // Belirli bir uçuşa ait rezervasyonları bulma
    List<Reservation> findByFlightId(Long flightId);

    // Belirli bir koltuğa ait rezervasyonu bulma (eğer koltuk seçimi mecburi ise tek sonuç dönebilir)
    List<Reservation> findBySeatId(Long seatId);
}
