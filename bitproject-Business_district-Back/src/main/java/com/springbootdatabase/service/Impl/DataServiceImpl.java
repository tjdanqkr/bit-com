package com.springbootdatabase.service.Impl;

import com.springbootdatabase.dao.DataDao;
import com.springbootdatabase.model.DataModel;
import com.springbootdatabase.model.Jsonreturn;
import com.springbootdatabase.model.MemberModel;
import com.springbootdatabase.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private DataDao dataDao;
    @Override
    public HashMap<String,List<Jsonreturn>> findData(DataModel data){

        List<Jsonreturn> json1 = dataDao.getGu(data);
        List<Jsonreturn> json2 = dataDao.getSung(data);
        List<Jsonreturn> json3 = dataDao.getZip(data);
        List<Jsonreturn> json4 = dataDao.getGun(data);

        HashMap<String,List<Jsonreturn>> json= new HashMap<>();
        json.put("gu",json1);
        json.put("sung",json2);
        json.put("zip",json3);
        json.put("gun",json4);
        return json;
    }


}
