package com.springbootdatabase.service;

import com.springbootdatabase.model.Biyong;
import com.springbootdatabase.model.MemberModel;
import com.springbootdatabase.model.hap;
import com.springbootdatabase.model.hap1;

import java.beans.BeanInfo;

public interface BiyongService {
    hap happrintbiyong(Biyong biyong);
    hap1 happrintbiyong1(Biyong biyong1);
    Biyong printbiyong(Biyong biyong);
    void insertbiyong(Biyong biyong);
    void deletebiyong(Biyong biyong);
    int checkId(Biyong biyong);
}
