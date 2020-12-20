package org.example;

import java.util.TreeMap;

public class TreeMapTest {


    public static void main(String[] args) {

        TreeMap<Integer,String> treeMap = new TreeMap<>();


        treeMap.put(8,"abc");
        treeMap.put(9,"abc");
        treeMap.put(5,"abc");

        for (Integer key :treeMap.keySet()){


            System.out.println(key + "    " + treeMap.get(key));



        }

    }
}
