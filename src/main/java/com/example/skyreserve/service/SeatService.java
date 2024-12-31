package com.example.skyreserve.service;

import com.example.skyreserve.dto.SeatDTO;
import com.example.skyreserve.entity.Flight;
import com.example.skyreserve.entity.Seat;
import com.example.skyreserve.repository.FlightRepository;
import com.example.skyreserve.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatService {

    private final SeatRepository seatRepository;
    private final FlightRepository flightRepository; // FlightRepository ekleniyor

    public SeatService(SeatRepository seatRepository, FlightRepository flightRepository) {
        this.seatRepository = seatRepository;
        this.flightRepository = flightRepository;
    }


    public SeatDTO createSeat(SeatDTO seatDTO) {
        // Flight nesnesi flightId'den yükleniyor
        Flight flight = flightRepository.findById(seatDTO.getFlightId())
                .orElseThrow(() -> new IllegalArgumentException("Flight not found with id: " + seatDTO.getFlightId()));

        Seat seat = new Seat(
                seatDTO.getSeatNumber(),
                seatDTO.getSeatType(),
                flight, // Flight burada set ediliyor
                seatDTO.isReserved()
        );

        Seat savedSeat = seatRepository.save(seat);
        return convertToDTO(savedSeat);
    }


    public SeatDTO getSeatById(Long id) {
        Seat seat = seatRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Seat not found with id: " + id));
        return convertToDTO(seat);
    }

    public List<SeatDTO> getAllSeats() {
        return seatRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public SeatDTO updateSeat(Long id, SeatDTO updatedSeatDTO) {
        Seat seat = seatRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Seat not found with id: " + id));
        seat.setSeatNumber(updatedSeatDTO.getSeatNumber());
        seat.setSeatType(updatedSeatDTO.getSeatType());
        seat.setReserved(updatedSeatDTO.isReserved());
        Seat savedSeat = seatRepository.save(seat);
        return convertToDTO(savedSeat);
    }

    public void deleteSeat(Long id) {
        seatRepository.deleteById(id);
    }

    public List<SeatDTO> getSeatsByFlightId(Long flightId) {
        return seatRepository.findByFlightId(flightId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void reserveSeat(Long id) {
        Seat seat = seatRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Seat not found with id: " + id));
        if (seat.getReserved()) {
            throw new IllegalStateException("Seat is already reserved");
        }
        seat.setReserved(true);
        seatRepository.save(seat);
    }

    public void cancelReservation(Long id) {
        Seat seat = seatRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Seat not found with id: " + id));
        seat.setReserved(false);
        seatRepository.save(seat);
    }

    private SeatDTO convertToDTO(Seat seat) {
        return new SeatDTO(seat.getId(), seat.getSeatNumber(), seat.getSeatType(), seat.getReserved());
    }
}
