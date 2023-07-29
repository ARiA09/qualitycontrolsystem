package com.example.qualitycontrolsystem.view;

import com.example.qualitycontrolsystem.controller.CityController;
import com.example.qualitycontrolsystem.controller.DistrictController;
import com.example.qualitycontrolsystem.controller.WardController;
import com.example.qualitycontrolsystem.model.City;
import com.example.qualitycontrolsystem.model.District;
import com.example.qualitycontrolsystem.model.SamplingPoint;
import com.example.qualitycontrolsystem.model.Ward;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class NewProjectFaces implements Serializable {

    private int cnt = 0;
    private final CityController cityController;
    private final DistrictController districtController;
    private final WardController wardController;
    private String cid;
    private String did;
    private String wid;
    private List<City> cities;
    private List<District> districts;
    private List<Ward> wards;
    private SamplingPoint selectedSamplingPoint;
    private List<SamplingPoint> selectedSamplingPoints;
    private List<SamplingPoint> samplingPoints = new ArrayList<>();

    public NewProjectFaces(@Autowired CityController cityController, @Autowired DistrictController districtController, @Autowired WardController wardController) {
        this.cityController = cityController;
        this.districtController = districtController;
        this.wardController = wardController;
    }

    @PostConstruct
    private void getAllCities() {
        cities = cityController.getAllCities();
    }

    public void onCityChange() {
        if (cid != null | !cid.equals("")) {
            districts = districtController.getDistrictByCity(cid);
        }
    }

    public void onDistrictChange() {
        if (did != null | !did.equals("")) {
            wards = wardController.getWardByDistrict(did);
        }
    }

    public void addSamplingPoint() {
        if (samplingPoints.stream().filter(s -> wid.equals(s.getLevel3ID())).findAny().orElse(null) == null) {
            SamplingPoint samplingPoint = new SamplingPoint();
            String cityName = cityController.getCityByCid(cid).getName();
            String districtName = districtController.getDistrictByDid(did).getName();
            String wardName = wardController.getWardBywID(wid).getName();

            if (cityName != null | cityName.equals("")) samplingPoint.setCityName(cityName);
            if (districtName != null | districtName.equals("")) samplingPoint.setDistrictName(districtName);
            if (wardName != null | wardName.equals("")) samplingPoint.setWardName(wardName);
            samplingPoint.setLevel3ID(wid);
            samplingPoint.setOrder(cnt++);
            samplingPoints.add(samplingPoint);
        }
    }

    //    private static void dumpEvents(UIComponentBase comp) {
//        System.out.println(
//                comp + ":\n\tdefaultEvent: " + comp.getDefaultEventName() + ";\n\tEvents: " + comp.getEventNames());
//    }
    public String getDeleteButtonMessage() {
        if (hasSelectedSamplingPoints()) {
            int size = this.selectedSamplingPoints.size();
            return size > 1 ? size + " Sampling Points selected" : "1 Sampling Point selected";
        }

        return "Delete";
    }

    public void deleteSamplingPoint() {
        this.samplingPoints.remove(this.selectedSamplingPoint);
//        this.selectedSamplingPoint.remove(this.selectedSamplingPoint);
        this.selectedSamplingPoint = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sampling Point Removed"));
        PrimeFaces.current().ajax().update("samplingPointTable:messages", "samplingPointTable:dt-samplingPoints");
    }

    public boolean hasSelectedSamplingPoints() {
        return this.selectedSamplingPoints != null && !this.selectedSamplingPoints.isEmpty();
    }

    public void deleteSamplingPoints() {
        this.samplingPoints.removeAll(this.selectedSamplingPoints);
        this.selectedSamplingPoints = null;
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Products Removed"));
        PrimeFaces.current().ajax().update("samplingPointTable:messages", "samplingPointTable:dt-samplingPoints");
        PrimeFaces.current().executeScript("PF('dtSamplingPoints').clearFilters()");
    }

    public List<City> getCities() {
        return cities;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public List<Ward> getWards() {
        return wards;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public List<SamplingPoint> getSamplingPoints() {
        return samplingPoints;
    }

    public void setSamplingPoints(List<SamplingPoint> samplingPoints) {
        this.samplingPoints = samplingPoints;
    }

    public List<SamplingPoint> getSelectedSamplingPoints() {
        return selectedSamplingPoints;
    }

    public SamplingPoint getSelectedSamplingPoint() {
        return selectedSamplingPoint;
    }

    public void setSelectedSamplingPoint(SamplingPoint selectedSamplingPoint) {
        this.selectedSamplingPoint = selectedSamplingPoint;
    }
}
