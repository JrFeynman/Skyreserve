package com.example.skyreserve.dto;

import java.time.LocalDateTime;

public class ReservationDTO {
    private Long id;
    private Long userId;
    private Long flightId;
    private Long seatId;
    private String status;
    private LocalDateTime reservationDate;

    private String username;
    private String flightNumber;
    private String seatNumber;

    public ReservationDTO() {}

    public ReservationDTO(Long id, Long userId, Long flightId, Long seatId, String status,
                          LocalDateTime reservationDate, String username, String flightNumber, String seatNumber) {
        this.setId(id);
        this.setUserId(userId);
        this.setFlightId(flightId);
        this.setSeatId(seatId);
        this.setStatus(status);
        this.setReservationDate(reservationDate);
        this.setUsername(username);
        this.setFlightNumber(flightNumber);
        this.setSeatNumber(seatNumber);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

}
