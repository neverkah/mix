package com.hzj;

import java.util.HashMap;
import java.util.Map;

public class MapTest {


    public static void main(String[] args) {
        Map<String,People> map = new HashMap<String,People>();

        People p = new People("zhangsan",4);

        map.put("zhangsan",p);

        People p2 =  map.remove("zhangsan");

        System.out.println(map.size());


    }
}
