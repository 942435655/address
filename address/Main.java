package com.tcwl.admin.address;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/4/21.
 */
public class Main {

    public static Boolean isProvince(String code) {
        if (code.endsWith("0000")) {
            return true;
        }
        return false;
    }

    public static Boolean isCity(String code) {
        if (code.endsWith("00")) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        File file = new File("C:\\Users\\admin\\Desktop\\city.txt");

        Map<String, Province> provinceMap = new HashMap<>();
        Map<String, City> cityMap = new HashMap<>();
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file), "utf-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            boolean first = true;
            while ((line = bufferedReader.readLine()) != null) {
                String code, name;
                if (first) {
                    first = false;
                    code = line.substring(1, 7);
                    name = line.substring(7);
                } else {
                    code = line.substring(0, 6);
                    name = line.substring(6);
                }

                if (isProvince(code)) {
                    Province province = new Province();
                    province.setParent(new ArrayList<>());
                    province.setParentId("1");
                    province.setProvince(name);
                    province.setRegionId(code);
                    provinceMap.put(code, province);
                } else if (isCity(code)) {
                    String parentId = code.substring(0,2)+"0000";
                    City city = new City();
                    city.setCounty(new ArrayList<>());
                    city.setParentId(parentId);
                    city.setRegionId(code);
                    city.setRegionName(name);

                    Province p = provinceMap.get(parentId);
                    p.getParent().add(city);
                    if ("市辖区".equals(name)) {
                        city.setRegionName(p.getProvince());
                    }
                    cityMap.put(code, city);
                } else {
                    String parentId = code.substring(0,4) + "00";
                    County county = new County();
                    county.setRegionId(code);
                    county.setRegionName(name);
                    county.setParentId(parentId);

                    City c = cityMap.get(parentId);
                    c.getCounty().add(county);
                }
            }
            ArrayList<Province> data = new ArrayList<>();
            for (String key : provinceMap.keySet()) {
                data.add(provinceMap.get(key));
            }
            Map<String, List<Province>> m = new HashMap<>();
            m.put("data", data);
            System.out.println(JSON.toJSONString(m));
            reader.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }


    }
}
