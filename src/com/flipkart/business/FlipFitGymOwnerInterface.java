package com.flipkart.business;

public interface FlipFitGymOwnerInterface {

    public void addGym(String gymName,String gymAddress);
    public void removeGym(Integer gymId);
    public void viewRegisteredGymCenters();
    public void viewSlots();
    public void addSlot(Integer gymId,String date, String startTime, String endTime,Integer noOfSeats);
    public void removeSlot(Integer gymId,Integer slotId);
    public void updateSlot(Integer gymId,Integer slotId, String details);
}
