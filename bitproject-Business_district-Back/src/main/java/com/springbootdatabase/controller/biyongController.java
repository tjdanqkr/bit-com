package com.springbootdatabase.controller;

import com.springbootdatabase.model.*;
import com.springbootdatabase.service.BiyongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class biyongController {
    @Autowired
    private BiyongService biyongService;

    @ResponseBody //
    @RequestMapping(value = "/api/biyong1", method = RequestMethod.POST)
    public List<Map<String, String>> biyong1(@RequestBody final HashMap<String, Object> post,
            HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("utf-8");

        Biyong biyong1 = new Biyong();
        biyong1.setId(post.get("id").toString());
        Biyong biyong2 = new Biyong();
        biyong2.setId(post.get("id").toString());

        hap biyong = biyongService.happrintbiyong(biyong1);// 다 더한것.
        hap1 biyong3 = biyongService.happrintbiyong1(biyong2);// month,ingun,zeryo,gita2+이자율

        System.out.println(biyong1.getId());
        System.out.println(biyong2.getId());

        System.out.println(biyong.getHap());
        System.out.println(biyong3.getHap());

        RestTemplate restTemplate = new RestTemplate();
        HashMap<String, String> map = new HashMap<>();
        String url = "http://localhost:5000/yearchui";
        map.put("dong", post.get("dong").toString());// request로 날아오는것에서 원하는 정보 빼줌
        HttpEntity<?> entity = new HttpEntity<>(map);
        ResponseEntity<predictyear[]> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity,
                predictyear[].class);
        System.out.println(responseEntity.getBody());

        predictyear[] a = responseEntity.getBody();

        List<Map<String, String>> list = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            float month2019 = Float.parseFloat(a[i].get월별2019매출예측());
            float month2020 = Float.parseFloat(a[i].get월별2020매출예측());
            String s = String.valueOf((int) (month2019));
            String y = String.valueOf((int) (month2020));
            String bis = String.valueOf(biyong.getHap());
            String biy = String.valueOf(biyong3.getHap());
            String m2019 = "";
            String m2020 = "";
            String mbs = "";
            String mby = "";
            System.out.println(s);
            System.out.println(y);
            for (int j = 1; j <= s.length(); ++j) {
                m2019 = s.charAt(s.length() - j) + m2019;
                System.out.println(m2019);

                if (j % 3 == 0 && j != s.length()) {
                    m2019 = "," + m2019;

                }
            }
            for (int j = 1; j <= y.length(); ++j) {

                m2020 = y.charAt(y.length() - j) + m2020;
                System.out.println(m2020);
                if (j % 3 == 0 && j != y.length()) {

                    m2020 = "," + m2020;
                }
            }
            for (int j = 1; j <= biy.length(); ++j) {

                mby = biy.charAt(biy.length() - j) + mby;
                if (j % 3 == 0 && j != biy.length()) {

                    mby = "," + mby;
                }
            }
            for (int j = 1; j <= bis.length(); ++j) {
                mbs = bis.charAt(bis.length() - j) + mbs;

                if (j % 3 == 0 && j != bis.length()) {
                    mbs = "," + mbs;

                }
            }
            HashMap<String, String> inmap = new HashMap<String, String>();

            inmap.put("월별2019매출예측", String.valueOf((int) (month2019)));
            inmap.put("월별2020매출예측", String.valueOf((int) (month2020)));
            inmap.put("hap", String.valueOf(biyong.getHap()));
            inmap.put("hap1", String.valueOf(biyong3.getHap()));
            inmap.put("월별2019매출예측2", m2019);
            inmap.put("월별2020매출예측2", m2020);
            inmap.put("hap2", mbs);
            inmap.put("hap12", mby);
            inmap.put("danga", biyong.getDanga());
            inmap.put("gil", a[i].get상권_코드_명()); // 길이름의 맵
            list.add(inmap);
        }
        // biyongService.deletebiyong(biyong1);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/api/gil", method = RequestMethod.POST)
    public CucheonDto[] gilcucheon(@RequestBody final HashMap<String, Object> post, HttpServletRequest request)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        RestTemplate restTemplate = new RestTemplate();
        HashMap<String, String> map = new HashMap<>();
        String url = "http://localhost:5000/gilcucheon";
        map.put("dong", post.get("dong").toString());

        HttpEntity<?> entity = new HttpEntity<>(map);

        ResponseEntity<CucheonDto[]> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity,
                CucheonDto[].class);
        System.out.println(responseEntity.getBody());
        CucheonDto[] list = responseEntity.getBody();

        return list;
    }

    @RequestMapping(value = "/api/biyong", method = RequestMethod.POST) // insert
    public String biyong(@RequestBody final HashMap<String, Object> post, HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("utf-8");
        Biyong biyong1 = new Biyong();
        biyong1.setId(post.get("id").toString());
        biyong1.setG(Integer.parseInt(post.get("g").toString()));
        biyong1.setB(Integer.parseInt(post.get("b").toString()));
        biyong1.setD(Integer.parseInt(post.get("d").toString()));
        biyong1.setI(Integer.parseInt(post.get("i").toString()));
        biyong1.setBuild(Integer.parseInt(post.get("build").toString()));
        biyong1.setInte(Integer.parseInt(post.get("inte").toString()));
        biyong1.setSul(Integer.parseInt(post.get("sul").toString()));
        biyong1.setGa(Integer.parseInt(post.get("ga").toString()));
        biyong1.setGita(Integer.parseInt(post.get("gita").toString()));
        biyong1.setChong(Integer.parseInt(post.get("chong").toString()));
        biyong1.setYear(Integer.parseInt(post.get("year").toString()));
        biyong1.setMenth(Integer.parseInt(post.get("menth").toString()));
        biyong1.setIngun(Integer.parseInt(post.get("ingun").toString()));
        biyong1.setZeryo(Integer.parseInt(post.get("zeryo").toString()));
        biyong1.setGita2(Integer.parseInt(post.get("gita2").toString()));
        biyong1.setDanga(Integer.parseInt(post.get("danga").toString()));

        biyongService.insertbiyong(biyong1);
        return "입력완료";
    }
}
