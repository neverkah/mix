package org.example;

public class Test1 {

    public static void main(String[] args) {

        for(int i = 1000;i<5000;i++){
            System.out.println("insert into user10(id,name) values(#id#,@@hostname);".replace("#id#",i+""));
        }

    }
}
