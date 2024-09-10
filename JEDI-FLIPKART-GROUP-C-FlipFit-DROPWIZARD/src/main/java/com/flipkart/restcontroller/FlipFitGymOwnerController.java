package com.flipkart.restcontroller;

import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitCenterSlot;
import com.flipkart.bean.FlipFitSlotBooking;
import com.flipkart.business.FlipFitGymOwnerService;
import com.flipkart.exception.InvalidGymException;
import com.flipkart.exception.UnauthorizedGymOwnerException;
import com.flipkart.exception.InvalidSlotException;
import com.flipkart.exception.InvalidUserException;
import com.flipkart.exception.GymSlotAlreadyExistsException;
import com.flipkart.validators.CityInputValidator;
import com.flipkart.validators.SlotInputValidator;
import com.flipkart.validators.GymOwnerValidator;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;

import static com.flipkart.utils.Helper.parseDate;
import static com.flipkart.utils.Helper.parseHourMinute;

@Path("/gymowner")
@Produces(MediaType.APPLICATION_JSON)
public class FlipFitGymOwnerController {

    private final FlipFitGymOwnerService ownerService = new FlipFitGymOwnerService();

    /**
     * Adds a new gym to the system.
     * This method consumes a JSON representation of a {@link FlipFitCentre} object and adds it using the provided user ID.
     * If the gym is added successfully, a response with a success message is returned.
     *
     * @param userId the ID of the user adding the gym
     * @param gym the {@link FlipFitCentre} object representing the gym to be added
     * @return a {@link Response} indicating the success of the operation
     */
    @POST
    @Path("/gym")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGym(@QueryParam("userId") String userId, @Valid FlipFitCentre gym) {
        ownerService.addGym(gym.getCity(), gym.getCentreName(), gym.getCentreAddress(), userId);
        return Response.ok("Gym added successfully.").build();
    }

    /**
     * Modifies an existing gym in the system.
     * This method consumes a JSON representation of a {@link FlipFitCentre} object and updates the gym with the specified gym ID.
     * It also uses the provided user ID to verify permissions. Responses vary based on the outcome of the modification.
     *
     * @param gymId the ID of the gym to be modified
     * @param userId the ID of the user performing the modification
     * @param gym the {@link FlipFitCentre} object containing the updated gym details
     * @return a {@link Response} indicating the result of the modification
     */
    @PUT
    @Path("/gym/{gymId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modifyGym(@PathParam("gymId") String gymId, @QueryParam("userId") String userId, @Valid FlipFitCentre gym) {
        try {
            boolean isSuccessful = ownerService.modifyGym(userId, gymId, gym.getCity(), gym.getCentreName(), gym.getCentreAddress());
            return isSuccessful ? Response.ok("Gym modified successfully.").build()
                    : Response.status(Response.Status.NOT_FOUND).entity("Gym not found.").build();
        } catch (UnauthorizedGymOwnerException e) {
            return Response.status(Response.Status.FORBIDDEN).entity("Unauthorized access.").build();
        } catch (InvalidGymException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid gym ID.").build();
        }
    }

    /**
     * Removes a gym from the system.
     * This method uses the provided gym ID and owner ID to delete a gym.
     * If the operation is successful, a success message is returned. If not authorized, an appropriate error message is returned.
     *
     * @param gymId the ID of the gym to be removed
     * @param ownerId the ID of the owner requesting the removal
     * @return a {@link Response} indicating the result of the removal operation
     */
    @DELETE
    @Path("/gym/{gymId}")
    public Response removeGym(@PathParam("gymId") String gymId, @QueryParam("ownerId") String ownerId) {
        try {
            ownerService.removeGym(ownerId, gymId);
            return Response.ok("Gym removed successfully.").build();
        } catch (UnauthorizedGymOwnerException e) {
            return Response.status(Response.Status.FORBIDDEN).entity("Unauthorized access.").build();
        }
    }

    /**
     * Retrieves a list of all gyms associated with the specified user.
     * This method returns a list of {@link FlipFitCentre} objects representing all gyms for the given user ID.
     *
     * @param userId the ID of the user whose gyms are to be retrieved
     * @return a {@link Response} containing a list of {@link FlipFitCentre} objects
     */
    @GET
    @Path("/gyms")
    public Response viewGyms(@QueryParam("userId") String userId) {
        List<FlipFitCentre> centres = ownerService.viewAllGymCentres(userId);
        return Response.ok(centres).build();
    }

    /**
     * Retrieves a list of gyms registered by the specified user.
     * This method returns a list of {@link FlipFitCentre} objects for gyms that are registered by the user with the given user ID.
     *
     * @param userId the ID of the user whose registered gyms are to be retrieved
     * @return a {@link Response} containing a list of {@link FlipFitCentre} objects
     */
    @GET
    @Path("/gyms/registered")
    public Response viewRegisteredGyms(@QueryParam("userId") String userId) {
        List<FlipFitCentre> centres = ownerService.viewRegisteredGymCenters(userId);
        return Response.ok(centres).build();
    }

    /**
     * Retrieves a list of gyms in a specific city for the given user.
     * This method validates the city name before fetching the list of gyms for that city and user ID.
     * If the city name is invalid, a bad request response is returned.
     *
     * @param userId the ID of the user whose gyms are to be retrieved
     * @param gymCity the city for which gyms are to be retrieved
     * @return a {@link Response} containing a list of {@link FlipFitCentre} objects or an error message
     */
    @GET
    @Path("/gyms/city")
    public Response viewGymsByCity(@QueryParam("userId") String userId, @QueryParam("city") String gymCity) {
        try {
            CityInputValidator.validateCityName(gymCity);
            List<FlipFitCentre> centres = ownerService.getGymListByCityAndOwner(gymCity, userId);
            return Response.ok(centres).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid city name.").build();
        }
    }

    /**
     * Adds a new slot to a gym.
     * This method uses the gym ID, start time, and number of seats to add a slot.
     * It validates the time format and seat capacity before performing the operation.
     *
     * @param gymId the ID of the gym where the slot is to be added
     * @param startTime the start time of the slot
     * @param noOfSeats the number of seats available in the slot
     * @return a {@link Response} indicating the result of the slot addition
     */
    @POST
    @Path("/slot")
    public Response addSlot(@QueryParam("gymId") String gymId, @QueryParam("startTime") String startTime, @QueryParam("seats") int noOfSeats) {
        try {
            SlotInputValidator.validateTimeFormat(startTime);
            SlotInputValidator.validateSeatCapacity(noOfSeats);
            ownerService.addSlot(gymId, parseHourMinute(startTime), noOfSeats);
            return Response.ok("Slot added successfully.").build();
        } catch (GymSlotAlreadyExistsException e) {
            return Response.status(Response.Status.CONFLICT).entity("Slot already exists.").build();
        } catch (InvalidGymException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Gym ID").build();
        } catch (SlotInputValidator e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Removes an existing slot from a gym.
     * This method uses the slot ID to remove the slot. If the slot ID is invalid, a bad request response is returned.
     *
     * @param slotId the ID of the slot to be removed
     * @return a {@link Response} indicating the result of the slot removal
     */
    @DELETE
    @Path("/slot/{slotId}")
    public Response removeSlot(@PathParam("slotId") String slotId) {
        try {
            ownerService.removeSlot(slotId);
            return Response.ok("Slot removed successfully.").build();
        } catch (InvalidSlotException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid slot ID.").build();
        }
    }

    /**
     * Updates an existing slot in a gym.
     * This method updates the slot details using the slot ID, start time, and number of seats.
     * It validates the time format and seat capacity before performing the update.
     *
     * @param slotId the ID of the slot to be updated
     * @param startTime the new start time for the slot
     * @param noOfSeats the new number of seats available in the slot
     * @return a {@link Response} indicating the result of the slot update
     */
    @PUT
    @Path("/slot/{slotId}")
    public Response editSlot(@PathParam("slotId") String slotId, @QueryParam("startTime") String startTime, @QueryParam("seats") int noOfSeats) {
        try {
            SlotInputValidator.validateTimeFormat(startTime);
            SlotInputValidator.validateSeatCapacity(noOfSeats);
            ownerService.updateSlot(slotId, parseHourMinute(startTime), noOfSeats);
            return Response.ok("Slot details updated!").build();
        } catch (InvalidSlotException | SlotInputValidator e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid slot ID.").build();
        }
    }

    /**
     * Retrieves all slots for a specific gym.
     * This method returns a list of {@link FlipFitCenterSlot} objects representing all slots for the given gym ID.
     *
     * @param gymId the ID of the gym whose slots are to be retrieved
     * @return a {@link Response} containing a list of {@link FlipFitCenterSlot} objects
     */
    @GET
    @Path("/slots")
    public Response viewAllSlots(@QueryParam("gymId") String gymId) {
        try {
            List<FlipFitCenterSlot> slots = ownerService.viewAllSlots(gymId);
            return Response.ok(slots).build();
        } catch (InvalidGymException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Gym ID.").build();
        }
    }

    /**
     * Retrieves a list of available slots for a specific gym on a specified date.
     * This method validates the date format before fetching the available slots from the gym.
     * If the gym ID is invalid or if there is a validation error with the date, an appropriate error message is returned.
     *
     * @param gymId the ID of the gym for which available slots are to be retrieved
     * @param date the date for which available slots are to be fetched, in the expected format
     * @return a {@link Response} containing a list of {@link FlipFitCenterSlot} objects or an error message
     */
    @GET
    @Path("/slots/available")
    public Response viewAvailableSlots(@QueryParam("gymId") String gymId, @QueryParam("date") String date) {
        try {
            SlotInputValidator.validateDateFormat(date);
            List<FlipFitCenterSlot> slots = ownerService.viewAvailableSlots(gymId, parseDate(date));
            return Response.ok(slots).build();
        } catch (InvalidGymException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Gym ID.").build();
        } catch (SlotInputValidator e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    /**
     * Retrieves a list of all bookings for a specific gym on a specified date.
     * This method validates the date format before fetching the bookings for that gym and date.
     * If the gym ID is invalid or there is a date validation error, an appropriate error message is returned.
     *
     * @param gymId the ID of the gym for which bookings are to be retrieved
     * @param date the date for which bookings are to be fetched, in the expected format
     * @return a {@link Response} containing a list of {@link FlipFitSlotBooking} objects or an error message
     */
    @GET
    @Path("/bookings")
    public Response viewAllBookings(@QueryParam("gymId") String gymId, @QueryParam("date") String date) {
        try {
            SlotInputValidator.validateDateFormat(date);
            List<FlipFitSlotBooking> bookings = ownerService.viewAllBookingsByGymIdAndDate(gymId, parseDate(date));
            return Response.ok(bookings).build();
        } catch (InvalidGymException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Gym ID.").build();
        } catch (SlotInputValidator e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    /**
     * Updates the profile information for a specific user.
     * This method validates the PAN and GST numbers before updating the user's profile with the new address, PAN, and GST details.
     * If the user ID is invalid or there are validation errors, an appropriate error message is returned.
     *
     * @param userId the ID of the user whose profile is to be updated
     * @param address the new address of the user
     * @param pan the new PAN card number of the user
     * @param gst the new GST number of the user
     * @return a {@link Response} indicating the result of the profile update
     */
    @PUT
    @Path("/profile")
    public Response editProfile(@QueryParam("userId") String userId, @QueryParam("address") String address, @QueryParam("pan") String pan, @QueryParam("gst") String gst) {
        try {
            GymOwnerValidator.validatePanCardNumber(pan);
            GymOwnerValidator.validateGstNumber(pan, gst);
            ownerService.editProfile(userId, address, gst, pan);
            return Response.ok("Profile updated successfully.").build();
        } catch (InvalidUserException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid user ID.").build();
        } catch (GymOwnerValidator e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
