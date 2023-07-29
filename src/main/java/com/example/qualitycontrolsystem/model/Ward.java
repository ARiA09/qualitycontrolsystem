package com.example.qualitycontrolsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Ward {

    @Id
    private String wid;

    @Column(name = "name")
    private String name;

    public Ward() {
    }

    public Ward(String wid, String name) {
        this.wid = wid;
        this.name = name;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
