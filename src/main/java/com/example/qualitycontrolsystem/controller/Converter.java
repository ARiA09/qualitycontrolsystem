package com.example.qualitycontrolsystem.controller;

public class Converter {

    public String convertID(String id) {
        String[] tmp = id.split("_");
        return tmp[0];
    }

    public Converter() {
    }
}
