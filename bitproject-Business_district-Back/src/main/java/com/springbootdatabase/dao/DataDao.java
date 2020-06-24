package com.springbootdatabase.dao;

import com.springbootdatabase.model.DataModel;
import com.springbootdatabase.model.Jsonreturn;

import java.util.HashMap;
import java.util.List;

public interface DataDao {
    //HashMap<String,Jsonreturn> getSang(DataModel dataModel);
    List<Jsonreturn> getGu(DataModel dataModel);
    List<Jsonreturn> getSung(DataModel dataModel);
    List<Jsonreturn> getZip(DataModel dataModel);
    List<Jsonreturn> getGun(DataModel dataModel);

}
