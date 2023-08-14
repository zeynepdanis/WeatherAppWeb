package com.example.WeatherWebApp.controller;


import com.example.WeatherWebApp.model.Weather;
import com.example.WeatherWebApp.service.WeatherService;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;




@RestController
@RequestMapping("/api/weather")
@CrossOrigin("http://localhost:5173")
public class WeatherController {

    @Autowired
    private WeatherService service;
    private ArrayList<String> cities=new ArrayList<>();







    @GetMapping("/home")
    public String Home() throws IOException {

        return service.Home();

    }



    @GetMapping("/current")

    public Weather getCurrentWeather() throws IOException {

        cities=service.getCityNames();
        Random random = new Random();
        String city= cities.get(random.nextInt(cities.size()));



        return service.getWeather(city);
    }



}
