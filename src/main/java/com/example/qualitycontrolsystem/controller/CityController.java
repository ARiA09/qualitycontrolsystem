package com.example.qualitycontrolsystem.controller;

import com.example.qualitycontrolsystem.model.City;
import com.example.qualitycontrolsystem.model.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class CityController {

    private City city;

    @Autowired
    CityRepository cityRepository;

    public List<City> getAllCities() {
        try {
            List<City> cities = new ArrayList<>();

            cityRepository.findAll().forEach(cities::add);
            return cities;

        } catch (Exception e) {
            return null;
        }
    }

    public City getCityByCid(String cid){
        return cityRepository.findCityByCid(cid);
    }



    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
