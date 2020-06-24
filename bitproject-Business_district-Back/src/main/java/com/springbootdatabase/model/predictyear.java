package com.springbootdatabase.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class predictyear {

    private String 월별2019매출예측;
    private String 월별2020매출예측;
    private String 상권_코드_명;
    private int 점포_수;

    public String get월별2019매출예측() {
        return 월별2019매출예측;
    }

    public void set월별2019매출예측(String 월별2019매출예측) {
        this.월별2019매출예측 = 월별2019매출예측;
    }

    public String get월별2020매출예측() {
        return 월별2020매출예측;
    }

    public void set월별2020매출예측(String 월별2020매출예측) {
        this.월별2020매출예측 = 월별2020매출예측;
    }

    public int get점포_수() {
        return 점포_수;
    }

    public void set점포_수(int 점포_수) {
        this.점포_수 = 점포_수;
    }

    public String get상권_코드_명() {
        return 상권_코드_명;
    }

    public void set상권_코드_명(String 상권_코드_명) {
        this.상권_코드_명 = 상권_코드_명;
    }
}