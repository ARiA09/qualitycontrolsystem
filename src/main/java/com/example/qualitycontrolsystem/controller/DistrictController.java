package com.example.qualitycontrolsystem.controller;

import com.example.qualitycontrolsystem.model.District;
import com.example.qualitycontrolsystem.model.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictController {

    @Autowired
    DistrictRepository districtRepository;

    private Converter converter = new Converter();

    public List<District> getDistrictByCity(String cID) {
        try {
            String convertID = converter.convertID(cID);
            List<District> districts = new ArrayList<>();
            districtRepository.findByDid(convertID).forEach(districts::add);
            return districts;

        } catch (Exception e) {
            return null;
        }
    }

    public District getDistrictByDid(String dID) {
        try {
            return districtRepository.findDistrictByDid(dID);
        } catch (Exception e) {
            return null;
        }
    }

}
