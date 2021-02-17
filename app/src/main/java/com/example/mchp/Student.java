package com.example.mchp;

import java.io.Serializable;

public class Student implements Serializable {
    private int age;
    private String name;
    private String company;

    public Student(int age, String name, String company) {
        this.age = age;
        this.name = name;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
