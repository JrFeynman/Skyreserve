package com.example.skyreserve.service;

import com.example.skyreserve.entity.Airport;
import com.example.skyreserve.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public Airport getAirportById(Long id) {
        return airportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Airport not found with id: " + id));
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Airport updateAirport(Long id, Airport updatedAirport) {
        Airport airport = getAirportById(id);
        airport.setName(updatedAirport.getName());
        airport.setCode(updatedAirport.getCode());
        airport.setCity(updatedAirport.getCity());
        airport.setCountry(updatedAirport.getCountry());
        return airportRepository.save(airport);
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }

    public Airport getAirportByCode(String code) {
        return airportRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException("Airport not found with code: " + code));
    }
}
