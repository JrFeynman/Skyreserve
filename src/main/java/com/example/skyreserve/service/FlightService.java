package com.example.skyreserve.service;

import com.example.skyreserve.entity.Flight;
import com.example.skyreserve.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Flight not found with id: " + id));
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight updateFlight(Long id, Flight updatedFlight) {
        Flight flight = getFlightById(id);
        flight.setFlightNumber(updatedFlight.getFlightNumber());
        flight.setAirline(updatedFlight.getAirline());
        flight.setOriginAirport(updatedFlight.getOriginAirport());
        flight.setDestinationAirport(updatedFlight.getDestinationAirport());
        flight.setDepartureTime(updatedFlight.getDepartureTime());
        flight.setArrivalTime(updatedFlight.getArrivalTime());
        flight.setCapacity(updatedFlight.getCapacity());
        flight.setPrice(updatedFlight.getPrice());
        return flightRepository.save(flight);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    public Flight getFlightByFlightNumber(String flightNumber) {
        return flightRepository.findByFlightNumber(flightNumber)
                .orElseThrow(() -> new IllegalArgumentException("Flight not found with flight number: " + flightNumber));
    }

    public List<Flight> searchFlights(String originCode, String destCode, LocalDateTime departureAfter) {
        return flightRepository.searchFlights(originCode, destCode, departureAfter);
    }
}
