package com.example.skyreserve.service;

import com.example.skyreserve.dto.AirlineDTO;
import com.example.skyreserve.entity.Airline;
import com.example.skyreserve.repository.AirlineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirlineService {

    private final AirlineRepository airlineRepository;

    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public AirlineDTO createAirline(AirlineDTO airlineDTO) {
        Airline airline = new Airline(airlineDTO.getName(), airlineDTO.getCode());
        Airline savedAirline = airlineRepository.save(airline);
        return convertToDTO(savedAirline);
    }

    public AirlineDTO getAirlineById(Long id) {
        Airline airline = airlineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Airline not found with id: " + id));
        return convertToDTO(airline);
    }

    public List<AirlineDTO> getAllAirlines() {
        return airlineRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AirlineDTO updateAirline(Long id, AirlineDTO updatedAirlineDTO) {
        Airline airline = airlineRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Airline not found with id: " + id));
        airline.setName(updatedAirlineDTO.getName());
        airline.setCode(updatedAirlineDTO.getCode());
        Airline savedAirline = airlineRepository.save(airline);
        return convertToDTO(savedAirline);
    }

    public void deleteAirline(Long id) {
        airlineRepository.deleteById(id);
    }

    private AirlineDTO convertToDTO(Airline airline) {
        return new AirlineDTO(airline.getId(), airline.getName(), airline.getCode());
    }
}
