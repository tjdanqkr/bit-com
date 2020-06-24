package com.springbootdatabase.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jsonreturn {

    private String sang;
    private float score;

    public String getSang() {
        return sang;
    }

    public void setSang(String sang) {
        this.sang = sang;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
