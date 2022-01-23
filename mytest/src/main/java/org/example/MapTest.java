package org.example;



import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {


    public static void main(String[] args) {

        Map<String, People> map = new ConcurrentHashMap<>();
        map.put("zhangsan",new People(111));
       for(int i =0;i<24;i++){
           map.put("zhangsan"+i,new People(1));
       }

       People  p =  map.get("zhangsan");

        System.out.println("1111");



    }

}
