package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymOwner;

public interface FlipFitGymOwnerDAOInterface {
    void createProfile(FlipFitGymOwner gymOwner);

    void editProfile(String gymOwnerId, String address, String gstNumber, String panCardNumber);
}
