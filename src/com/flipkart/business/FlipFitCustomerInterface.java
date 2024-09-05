package com.flipkart.business;

import com.flipkart.bean.FlipfitCenterSlot;
import com.flipkart.bean.FlipfitCentre;
import com.flipkart.bean.FlipfitCustomer;

import java.util.HashMap;
import java.util.List;

public interface FlipFitCustomerInterface {


    HashMap<String, Integer> viewSlots(int centerId, String date);

    void createProfile(int userId, String name, String phoneNumber, String address);

    void editProfile(int userId, String name, String phoneNumber, String address);
    //add exception if usser is not found


    List<FlipfitCentre> viewCenter();
}
