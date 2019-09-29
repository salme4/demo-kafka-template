package com.myhome.demokafkatemplate.model;

import java.io.Serializable;

public class User implements Serializable {

    public User() {
    }

    public User(String message) {
        this.name=message;
    }

    private String name;
    private int age = 34;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
