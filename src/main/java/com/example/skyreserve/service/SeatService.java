package com.example.skyreserve.service;

import com.example.skyreserve.entity.Seat;
import com.example.skyreserve.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public Seat getSeatById(Long id) {
        return seatRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Seat not found with id: " + id));
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Seat updateSeat(Long id, Seat updatedSeat) {
        Seat seat = getSeatById(id);
        seat.setSeatNumber(updatedSeat.getSeatNumber());
        seat.setSeatType(updatedSeat.getSeatType());
        seat.setFlight(updatedSeat.getFlight());
        return seatRepository.save(seat);
    }

    public void deleteSeat(Long id) {
        seatRepository.deleteById(id);
    }

    public List<Seat> getSeatsByFlightId(Long flightId) {
        return seatRepository.findByFlightId(flightId);
    }

    public List<Seat> findSeatByFlightAndNumber(Long flightId, String seatNumber) {
        return seatRepository.findByFlightIdAndSeatNumber(flightId, seatNumber);
    }
}
