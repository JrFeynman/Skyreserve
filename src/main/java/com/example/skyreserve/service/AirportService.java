package com.example.skyreserve.service;

import com.example.skyreserve.dto.AirportDTO;
import com.example.skyreserve.entity.Airport;
import com.example.skyreserve.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public AirportDTO createAirport(AirportDTO airportDTO) {
        Airport airport = new Airport(
                airportDTO.getName(),
                airportDTO.getCode(),
                airportDTO.getCity(),
                airportDTO.getCountry()
        );
        Airport savedAirport = airportRepository.save(airport);
        return convertToDTO(savedAirport);
    }

    public AirportDTO getAirportById(Long id) {
        Airport airport = airportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Airport not found with id: " + id));
        return convertToDTO(airport);
    }

    public List<AirportDTO> getAllAirports() {
        return airportRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AirportDTO updateAirport(Long id, AirportDTO updatedAirportDTO) {
        Airport airport = airportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Airport not found with id: " + id));
        airport.setName(updatedAirportDTO.getName());
        airport.setCode(updatedAirportDTO.getCode());
        airport.setCity(updatedAirportDTO.getCity());
        airport.setCountry(updatedAirportDTO.getCountry());
        Airport savedAirport = airportRepository.save(airport);
        return convertToDTO(savedAirport);
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }

    private AirportDTO convertToDTO(Airport airport) {
        return new AirportDTO(airport.getId(), airport.getName(), airport.getCode(), airport.getCity(), airport.getCountry());
    }
}
