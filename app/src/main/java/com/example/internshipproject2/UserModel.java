package com.example.internshipproject2;

public class UserModel {


    String Name,Age,Gender;
    String Email;
    String PhoneNumber;
    String Profession;
    public UserModel(){

    }
    public UserModel(String name, String age, String gender, String email, String phonenumber,String profession) {
        Name = name;
        Age = age;
        Gender=gender;
        Email=email;
        PhoneNumber=phonenumber;
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

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) { Gender= gender; }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) { Email = email; }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phonenumber) {PhoneNumber = phonenumber; }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }


}
