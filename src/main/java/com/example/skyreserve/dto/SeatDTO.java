package com.example.skyreserve.dto;

public class SeatDTO {
    private Long id;
    private String seatNumber;
    private String seatType;
    private Long flightId;
    private boolean reserved;

    public SeatDTO(Long id, String seatNumber, String seatType, boolean reserved) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.reserved = reserved;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }


    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
}
