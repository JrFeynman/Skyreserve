package com.example.skyreserve.dto;

public class AirportDTO {
    private Long id;
    private String name;
    private String code;
    private String city;
    private String country;

    public AirportDTO(Long id, String name, String code, String city, String country) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.city = city;
        this.country = country;
    }

    // Getters ve Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id != null) {
            throw new IllegalArgumentException("ID alanı set edilemez");
        }
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
