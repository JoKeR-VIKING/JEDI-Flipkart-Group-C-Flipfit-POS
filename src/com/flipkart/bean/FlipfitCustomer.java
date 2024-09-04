package com.flipkart.bean;

import com.flipkart.enums.RoleEnum;

import java.time.LocalDate;

public class FlipfitCustomer extends FlipfitUser{
    private Double weight;
    private Integer age;
    private String gender;
    private LocalDate dob;

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

    public RoleEnum getRole() {
        return RoleEnum.CUSTOMER;
    }


}
