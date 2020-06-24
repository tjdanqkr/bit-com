package com.springbootdatabase.dao;

import com.springbootdatabase.model.Biyong;
import com.springbootdatabase.model.hap;
import com.springbootdatabase.model.hap1;

public interface BiyongDao {
    hap happrintbiyong(Biyong biyong);
    hap1 happrintbiyong1(Biyong biyong1);
    
    void updateBiyong(Biyong biyong);
    void setBiyong(Biyong biyong);
    void deleteBiyong(Biyong biyong);

    int checkId(Biyong biyong);
}
