package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.exception.ExistingUserException;

public interface FlipFitGymOwnerDAOInterface {
    void createProfile(FlipFitGymOwner gymOwner) throws ExistingUserException;

    void editProfile(String gymOwnerId, String address, String gstNumber, String panCardNumber);
}
