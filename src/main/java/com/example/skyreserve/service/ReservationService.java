package com.example.skyreserve.service;

import com.example.skyreserve.entity.Reservation;
import com.example.skyreserve.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found with id: " + id));
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        Reservation reservation = getReservationById(id);
        reservation.setUser(updatedReservation.getUser());
        reservation.setFlight(updatedReservation.getFlight());
        reservation.setSeat(updatedReservation.getSeat());
        reservation.setStatus(updatedReservation.getStatus());
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public List<Reservation> getReservationsByUserId(Long userId) {
        return reservationRepository.findByUserId(userId);
    }

    public List<Reservation> getReservationsByFlightId(Long flightId) {
        return reservationRepository.findByFlightId(flightId);
    }

    public List<Reservation> getReservationsBySeatId(Long seatId) {
        return reservationRepository.findBySeatId(seatId);
    }
}
