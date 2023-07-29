package com.example.qualitycontrolsystem.model;

import jakarta.persistence.*;


@Entity
@Table
public class District {

    @Id
    private String did;

    @Column(name = "name")
    private String name;

    public District() {
    }

    public District(String did, String name) {
        this.did = did;
        this.name = name;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
