package com.example.qualitycontrolsystem.model;

public class SamplingPoint {

    private int order;
    private String level3ID;
    private String cityName;
    private String districtName;
    private String wardName;

    public String getLevel3ID() {
        return level3ID;
    }

    public void setLevel3ID(String level3ID) {
        this.level3ID = level3ID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
