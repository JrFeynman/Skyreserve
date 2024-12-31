package com.example.skyreserve.service;

import com.example.skyreserve.dto.FlightDTO;
import com.example.skyreserve.dto.SeatDTO;
import com.example.skyreserve.entity.Airline;
import com.example.skyreserve.entity.Airport;
import com.example.skyreserve.entity.Flight;
import com.example.skyreserve.entity.Seat;
import com.example.skyreserve.repository.AirlineRepository;
import com.example.skyreserve.repository.AirportRepository;
import com.example.skyreserve.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;
    private final AirlineRepository airlineRepository;

    public FlightService(FlightRepository flightRepository, AirportRepository airportRepository, AirlineRepository airlineRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
        this.airlineRepository = airlineRepository;
    }

    public FlightDTO addFlight(FlightDTO flightDTO) {
        // Havalimanlarını ve hava yolunu eşleştir
        Airport originAirport = airportRepository.findByName(flightDTO.getOriginAirportName())
                .orElseThrow(() -> new IllegalArgumentException("Origin airport not found."));
        Airport destinationAirport = airportRepository.findByName(flightDTO.getDestinationAirportName())
                .orElseThrow(() -> new IllegalArgumentException("Destination airport not found."));
        Airline airline = airlineRepository.findByName(flightDTO.getAirlineName())
                .orElseThrow(() -> new IllegalArgumentException("Airline not found."));

        Flight flight = new Flight(
                flightDTO.getFlightNumber(),
                airline,
                originAirport,
                destinationAirport,
                flightDTO.getDepartureTime(),
                flightDTO.getArrivalTime(),
                flightDTO.getCapacity(),
                flightDTO.getPrice()
        );

        Flight savedFlight = flightRepository.save(flight);
        return convertToDTO(savedFlight);

    }

    public List<FlightDTO> getAllFlights() {
        return flightRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<FlightDTO> searchFlightsByCities(String originCity, String destinationCity) {
        return flightRepository.searchByCities(originCity, destinationCity).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
    public FlightDTO getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Flight not found with id: " + id));
        return convertToDTO(flight);
    }

    private FlightDTO convertToDTO(Flight flight) {
        return new FlightDTO(
                flight.getId(),
                flight.getFlightNumber(),
                flight.getOriginAirport().getCity(),
                flight.getDestinationAirport().getCity(),
                flight.getAirline().getName(),
                flight.getDepartureTime(),
                flight.getArrivalTime(),
                flight.getPrice(),
                flight.getCapacity(),
                flight.getSeats().stream().map(this::convertSeatToDTO).collect(Collectors.toList())
        );
    }

    private SeatDTO convertSeatToDTO(Seat seat) {
        return new SeatDTO(
                seat.getId(),
                seat.getSeatNumber(),
                seat.getSeatType(),
                seat.getReserved()
        );
    }

}

