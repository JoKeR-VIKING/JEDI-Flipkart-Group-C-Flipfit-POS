package com.flipkart.bean;

import com.flipkart.enums.RoleEnum;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Represents a customer in the FlipFit system.
 * This class extends {@link FlipFitUser} and includes additional details specific to customers.
 */
public class FlipFitCustomer extends FlipFitUser {
    @NotNull
    private Double weight;
    @NotNull
    private Integer age;
    @NotBlank
    private String gender;
    @NotBlank
    private LocalDate dob;

    /**
     * Constructs a new FlipFitCustomer with the specified details.
     *
     * @param id          the unique identifier for the customer
     * @param username    the username of the customer
     * @param password    the password for the customer account
     * @param name        the name of the customer
     * @param address     the address of the customer
     * @param phoneNumber the phone number of the customer
     * @param weight      the weight of the customer
     * @param age         the age of the customer
     * @param gender      the gender of the customer
     * @param dob         the date of birth of the customer
     */
    public FlipFitCustomer(String id, String username, String password, String name, String address, String phoneNumber, Double weight, Integer age, String gender, LocalDate dob) {
        super(id, username, password, name, address, phoneNumber, RoleEnum.CUSTOMER);
        this.weight = weight;
        this.age = age;
        this.gender = gender;
        this.dob = dob;
    }

    /**
     * Returns the gender of the customer.
     *
     * @return the gender of the customer
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of the customer.
     *
     * @param gender the new gender of the customer
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Returns the age of the customer.
     *
     * @return the age of the customer
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Sets the age of the customer.
     *
     * @param age the new age of the customer
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Returns the weight of the customer.
     *
     * @return the weight of the customer
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the customer.
     *
     * @param weight the new weight of the customer
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * Returns the date of birth of the customer.
     *
     * @return the date of birth of the customer
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * Sets the date of birth of the customer.
     *
     * @param dob the new date of birth of the customer
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
