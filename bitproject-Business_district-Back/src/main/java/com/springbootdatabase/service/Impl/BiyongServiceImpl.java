package com.springbootdatabase.service.Impl;

import com.springbootdatabase.dao.BiyongDao;
import com.springbootdatabase.model.Biyong;
import com.springbootdatabase.model.hap;
import com.springbootdatabase.model.hap1;
import com.springbootdatabase.service.BiyongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootdatabase.model.hap;
@Service
public class BiyongServiceImpl implements BiyongService {

    @Autowired
    BiyongDao biyongDao;
    @Autowired
    BiyongService biyongService;

    @Override
    public hap happrintbiyong(final Biyong biyong) {
        final hap biyong1 = biyongDao.happrintbiyong(biyong);
        System.out.println(biyong1);
        return biyong1;
    }

    @Override
    public hap1 happrintbiyong1(final Biyong biyong1) {
        final hap1 biyong2 = biyongDao.happrintbiyong1(biyong1);
        System.out.println(biyong2);
        return biyong2;
    }
    @Override
    public void insertbiyong(final Biyong biyong) {
        int result = biyongService.checkId(biyong);

        if (result > 0 )
        {
           biyongDao.updateBiyong(biyong);
        }
        else
        {
            biyongDao.setBiyong(biyong);
        }
    }
    @Override
    public int checkId(final Biyong biyong){
        int result = biyongDao.checkId(biyong);
        return result;
    }
    @Override
    public void deletebiyong(final Biyong biyong) {
        biyongDao.deleteBiyong(biyong);
    }

    @Override
    public Biyong printbiyong(final Biyong biyong) {
        // TODO Auto-generated method stub
        return null;
    }
}
