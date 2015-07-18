package com.example.emp00037872.recyclerproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EMP00037872 on 17.07.15.
 */
public class Person {
    String name;
    String age;

    Person(String name, String age) {
        this.name = name;
        this.age = age;
    }
    String getName(){
        return this.name;
    }
    public Person copy(){
        Person copy = new Person(name,age);
        return copy;

    }
}


