package com.example.assignment02;

import java.io.Serializable;

public class Profile implements Serializable {

    String name, age, feeling, imageFeeling;

    public Profile(String name, String age, String feeling) {
        this.name = name;
        this.age = age;
        this.feeling = feeling;
    }

    public Profile() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFeeling() {
        return feeling;
    }

    public void setFeeling(String feeling) {
        this.feeling = feeling;
    }
}
