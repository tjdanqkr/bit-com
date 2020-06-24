package com.springbootdatabase.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataModel {

    private String bub;

    public String getBub() {
        return bub;
    }

    public void setBub(String bub) {
        this.bub = bub;
    }
}
