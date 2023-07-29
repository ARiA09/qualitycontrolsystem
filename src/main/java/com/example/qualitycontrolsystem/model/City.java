package com.example.qualitycontrolsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class City {

    @Id
    private String cid;

    @Column
    private String name;

    public City() {
    }

    public City(String cid, String name) {
        this.cid = cid;
        this.name = name;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
