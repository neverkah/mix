package com.journaldev.collections;


import java.util.Comparator;

public class Customer implements Comparable<Customer> {

 

    private int id;

    private String name;

 

    public Customer(int i, String n){

        this.id=i;

        this.name=n;

    }

 

    public int getId() {

        return id;

    }

 

    public String getName() {

        return name;

    }


    @Override
    public int compareTo(Customer o) {
      //  return id-o.getId();
        return 0;
    }
}