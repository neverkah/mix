package com.juc;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Person {


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String name;

    int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return new EqualsBuilder()
                .append(age, person.age)
                .append(name, person.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(age)
                .toHashCode();
    }
}
