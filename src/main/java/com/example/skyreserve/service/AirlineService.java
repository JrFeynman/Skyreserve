package com.example.skyreserve.service;

import com.example.skyreserve.entity.Airline;
import com.example.skyreserve.repository.AirlineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService {

    private final AirlineRepository airlineRepository;

    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public Airline createAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    public Airline getAirlineById(Long id) {
        return airlineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Airline not found with id: " + id));
    }

    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }

    public Airline updateAirline(Long id, Airline updatedAirline) {
        Airline airline = getAirlineById(id);
        airline.setName(updatedAirline.getName());
        airline.setCode(updatedAirline.getCode());
        return airlineRepository.save(airline);
    }

    public void deleteAirline(Long id) {
        airlineRepository.deleteById(id);
    }

    public Airline getAirlineByCode(String code) {
        return airlineRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException("Airline not found with code: " + code));
    }
}
