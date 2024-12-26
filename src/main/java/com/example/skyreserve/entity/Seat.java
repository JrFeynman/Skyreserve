package com.example.skyreserve.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="seat_number", nullable=false)
    private String seatNumber; // Örn: "12A"

    @Column(name="seat_type")
    private String seatType; // Örn: "WINDOW", "AISLE"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    public Seat() {}

    public Seat(String seatNumber, String seatType, Flight flight) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.flight = flight;
    }

    public Long getId() {
        return id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
