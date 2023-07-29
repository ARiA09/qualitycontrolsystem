package com.example.qualitycontrolsystem.controller;

import com.example.qualitycontrolsystem.model.Ward;
import com.example.qualitycontrolsystem.model.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WardController {

    @Autowired
    WardRepository wardRepository;

    private Converter converter = new Converter();

    public List<Ward> getWardByDistrict(String cID) {
        try {
            String convertID = converter.convertID(cID);
            List<Ward> wards = new ArrayList<>();
            wardRepository.findByWid(convertID).forEach(wards::add);
            return wards;

        } catch (Exception e) {
            return null;
        }
    }

    public Ward getWardBywID(String wID) {
        try {
            return wardRepository.findWardByWid(wID);
        } catch (Exception e) {
            return null;
        }
    }

}
