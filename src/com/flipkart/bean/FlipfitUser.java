package com.flipkart.bean;

import com.flipkart.enums.RoleEnum;

public abstract class FlipfitUser {
    private String id;
    private String username;
    private String password;
    private String name;
    private Boolean verfied;
    private String address;
    private String phoneNumber;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getVerfied() {
        return verfied;
    }

    public void setVerfied(Boolean verfied) {
        this.verfied = verfied;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    abstract public RoleEnum getRole();

}
