package com.example.WeatherWebApp.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Weather implements Serializable {

    private String description;


    private String country;

    private String cityName;
    private BigDecimal temperature;
    private BigDecimal feelsLike;

    private BigDecimal windSpeed;

    public Weather(){}

    public Weather(String cityName,String country,String description, BigDecimal temperature, BigDecimal feelsLike, BigDecimal windSpeed) {
        this.cityName=cityName;
        this.country=country;
        this.description = description;
        this.temperature = temperature;
        this.feelsLike = feelsLike;
        this.windSpeed = windSpeed;
    }
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public BigDecimal getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(BigDecimal feelsLike) {
        this.feelsLike = feelsLike;
    }

    public BigDecimal getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(BigDecimal windSpeed) {
        this.windSpeed = windSpeed;
    }






}
