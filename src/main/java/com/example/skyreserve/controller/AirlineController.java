package com.example.skyreserve.controller;

import com.example.skyreserve.dto.AirlineDTO;
import com.example.skyreserve.service.AirlineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airlines")
public class AirlineController {

    private final AirlineService airlineService;

    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping
    public ResponseEntity<List<AirlineDTO>> getAllAirlines() {
        return ResponseEntity.ok(airlineService.getAllAirlines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirlineDTO> getAirlineById(@PathVariable Long id) {
        return ResponseEntity.ok(airlineService.getAirlineById(id));
    }

    @PostMapping
    public ResponseEntity<AirlineDTO> createAirline(@RequestBody AirlineDTO airlineDTO) {
        AirlineDTO createdAirline = airlineService.createAirline(airlineDTO);
        return ResponseEntity.status(201).body(createdAirline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirlineDTO> updateAirline(@PathVariable Long id, @RequestBody AirlineDTO updatedAirlineDTO) {
        AirlineDTO updatedAirline = airlineService.updateAirline(id, updatedAirlineDTO);
        return ResponseEntity.ok(updatedAirline);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirline(@PathVariable Long id) {
        airlineService.deleteAirline(id);
        return ResponseEntity.noContent().build();
    }
}
