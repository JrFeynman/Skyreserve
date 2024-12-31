package com.example.skyreserve.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class FlightDTO {
    private Long id;
    private String flightNumber;
    private String originAirportName;
    private String destinationAirportName;
    private String airlineName;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private BigDecimal price;
    private Integer capacity;
    private List<SeatDTO> seats;

    public FlightDTO() {}

    public FlightDTO(Long id, String flightNumber, String originAirportName, String destinationAirportName,
                     String airlineName, LocalDateTime departureTime, LocalDateTime arrivalTime,
                     BigDecimal price, Integer capacity, List<SeatDTO> seats) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.originAirportName = originAirportName;
        this.destinationAirportName = destinationAirportName;
        this.airlineName = airlineName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.capacity = capacity;
        this.seats = seats;
    }

    // Getters ve Setters (Tamamı Eklendi)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public String getOriginAirportName() { return originAirportName; }
    public void setOriginAirportName(String originAirportName) { this.originAirportName = originAirportName; }

    public String getDestinationAirportName() { return destinationAirportName; }
    public void setDestinationAirportName(String destinationAirportName) { this.destinationAirportName = destinationAirportName; }

    public String getAirlineName() { return airlineName; }
    public void setAirlineName(String airlineName) { this.airlineName = airlineName; }

    public LocalDateTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }

    public LocalDateTime getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(LocalDateTime arrivalTime) { this.arrivalTime = arrivalTime; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public List<SeatDTO> getSeats() { return seats; }
    public void setSeats(List<SeatDTO> seats) { this.seats = seats; }
}
