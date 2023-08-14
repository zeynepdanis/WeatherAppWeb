package com.example.WeatherWebApp.service;


import com.example.WeatherWebApp.exception.ApiRequestException;
import com.example.WeatherWebApp.model.Weather;
import com.fasterxml.jackson.core.JsonProcessingException;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;


import java.io.InputStream;
import java.math.BigDecimal;
import java.math.MathContext;
import java.net.URI;

import java.util.ArrayList;

import java.util.HashMap;



@Service
public class WeatherService {






    private  static final String URL="https://api.openweathermap.org/data/2.5/weather?q={city name}&appid=330a52c650da2c84ca57a6b5d7b1618d&units=metric";

    private HashMap<String, String> CountryCities = new HashMap<>();
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;


    public WeatherService(RestTemplateBuilder restTemplateBuilder,ObjectMapper objectMapper){

        this.restTemplate=restTemplateBuilder.build();
        this.objectMapper=objectMapper;
    }

    private final ArrayList<String> cities=new ArrayList<>();



    public String Home(){

        return "The current weather information for randomly selected cities";
    }
    public ArrayList<String> getCityNames() {


        try {

            InputStream inputStream=getClass().getResourceAsStream("/json/city.list.json");
            ObjectMapper mapper=new ObjectMapper();

            JsonNode nodes = mapper.readTree(inputStream);

            for (JsonNode node : nodes) {


                cities.add(node.path("name").asText());
                CountryCities.put(node.path("name").asText(),node.path("country").asText());




            }



        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return cities;


    }
    public Weather getWeather(String city){




        URI url=new UriTemplate(URL).expand(city);
        ResponseEntity<String>response=restTemplate.getForEntity(url,String.class);
        int statusCode = response.getStatusCodeValue();

        if(statusCode==200){
            return convert(city,response);
        }
        else{

            throw new ApiRequestException("City's weather information can not be found.");
        }










    }


    private Weather convert(String city,ResponseEntity<String>response){

        MathContext m = new MathContext(3);
        try{
            JsonNode root=objectMapper.readTree(response.getBody());
            return new Weather(city,CountryCities.get(city),

                    root.path("weather").get(0).path("main").asText(),

                    BigDecimal.valueOf(root.path("main").path("temp").asDouble()).round(m),
                    BigDecimal.valueOf(root.path("main").path("feels_like").asDouble()).round(m),
                    BigDecimal.valueOf(root.path("wind").path("speed").asDouble()));







        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}