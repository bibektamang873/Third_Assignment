package com.example.third_assignment.Model;



public class Student {
    private String fullName, gender, address;
    private int age;

    public Student(String fullName, String gender, String address, int age) {
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }
}
