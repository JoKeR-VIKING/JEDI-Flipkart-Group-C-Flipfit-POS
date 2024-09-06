package com.flipkart.bean;

import java.time.LocalDate;

public class FlipFitCustomer extends FlipFitUser {
    private Double weight;
    private Integer age;
    private String gender;
    private LocalDate dob;

    public FlipFitCustomer(String id, String username, String password, String name, String address, String phoneNumber, Double weight, Integer age, String gender, LocalDate dob) {
        super(id, username, password, name, address, phoneNumber);
        this.weight = weight;
        this.age = age;
        this.gender = gender;
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
