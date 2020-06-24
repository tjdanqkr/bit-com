package com.springbootdatabase.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Upjong {

   private String[] dong2;
   private int count;

    public String[] getDong2() {
        return dong2;
    }

    public void setDong2(String[] dong2) {
        this.dong2 = dong2;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
