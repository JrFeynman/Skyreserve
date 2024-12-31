package com.example.skyreserve.service;

import com.example.skyreserve.dto.ReservationDTO;
import com.example.skyreserve.entity.Flight;
import com.example.skyreserve.entity.Reservation;
import com.example.skyreserve.entity.Seat;
import com.example.skyreserve.entity.User;
import com.example.skyreserve.repository.FlightRepository;
import com.example.skyreserve.repository.ReservationRepository;
import com.example.skyreserve.repository.SeatRepository;
import com.example.skyreserve.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final SeatRepository seatRepository;
    private final UserRepository userRepository;
    private final FlightRepository flightRepository;

    public ReservationService(ReservationRepository reservationRepository, SeatRepository seatRepository,
                              UserRepository userRepository, FlightRepository flightRepository) {
        this.reservationRepository = reservationRepository;
        this.seatRepository = seatRepository;
        this.userRepository = userRepository;
        this.flightRepository = flightRepository;
    }

    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        User user = userRepository.findById(reservationDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Flight flight = flightRepository.findById(reservationDTO.getFlightId())
                .orElseThrow(() -> new IllegalArgumentException("Flight not found"));

        Seat seat = null;
        if (reservationDTO.getSeatId() != null) {
            seat = seatRepository.findById(reservationDTO.getSeatId())
                    .orElseThrow(() -> new IllegalArgumentException("Seat not found"));
            if (seat.getReserved()) {
                throw new IllegalStateException("Seat is already reserved");
            }
            seat.setReserved(true);
            seatRepository.save(seat);
        }

        Reservation reservation = new Reservation(user, flight, seat, reservationDTO.getStatus());
        reservation.setReservationDate(LocalDateTime.now());

        Reservation savedReservation = reservationRepository.save(reservation);
        return convertToDTO(savedReservation);
    }

    public List<ReservationDTO> getAllReservations() {
        return reservationRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ReservationDTO getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found"));
        return convertToDTO(reservation);
    }

    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found"));
        if (reservation.getSeat() != null) {
            Seat seat = reservation.getSeat();
            seat.setReserved(false);
            seatRepository.save(seat);
        }
        reservationRepository.delete(reservation);
    }


    private ReservationDTO convertToDTO(Reservation reservation) {
        return new ReservationDTO(
                reservation.getId(),
                reservation.getUser().getId(),
                reservation.getFlight().getId(),
                reservation.getSeat() != null ? reservation.getSeat().getId() : null,
                reservation.getStatus(),
                reservation.getReservationDate(),
                reservation.getUser().getUsername(),
                reservation.getFlight().getFlightNumber(),
                reservation.getSeat() != null ? reservation.getSeat().getSeatNumber() : null
        );
    }
}

