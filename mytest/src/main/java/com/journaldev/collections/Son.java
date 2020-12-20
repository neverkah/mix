package com.journaldev.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Son extends Father  {
     //放大输入参数类型 
     public Collection doSomething (Map map){
             System .out.println ("子类被执行..."); 
             return map .values (); 
      }


@Override
    public HashMap buyApple(){
       HashMap hashMap = new HashMap();
        return hashMap;
    }


    public static void main(String[] args) {



         Map map = new HashMap();

       Son f = new Son();
//    Father f = new Father();

         f.doSomething(map);


    }

    public  void test(){
         Father f   = new Father();

      //  Map  f.buyApple()



    }
} 