package com.example.internshipproject2;

public class UserModel {

    String Name,Age,Profession;

    public UserModel(String name, String age, String profession) {
        Name = name;
        Age = age;
        Profession = profession;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }
}
