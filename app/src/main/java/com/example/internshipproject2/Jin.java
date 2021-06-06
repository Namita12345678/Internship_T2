package com.example.internshipproject2;


import java.io.Serializable;
public class Jin implements Serializable {
    public static final String EXTRA ="com.example.internshipproject2";


    String username,password,name,age,profession;
    String phone_number,gender;

    public Jin(){
    }


    public Jin(String username, String password, String address, String state, String phone_number, String gender) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.profession=profession;
        this.phone_number = phone_number;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}



