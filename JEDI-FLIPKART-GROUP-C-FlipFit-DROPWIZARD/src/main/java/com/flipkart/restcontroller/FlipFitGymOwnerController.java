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

    @POST
    @Path("/gym")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGym(@QueryParam("userId") String userId, @Valid FlipFitCentre gym) {
        ownerService.addGym(gym.getCity(), gym.getCentreName(), gym.getCentreAddress(), userId);
        return Response.ok("Gym added successfully.").build();
    }

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

    @GET
    @Path("/gyms")
    public Response viewGyms(@QueryParam("userId") String userId) {
        List<FlipFitCentre> centres = ownerService.viewAllGymCentres(userId);
        return Response.ok(centres).build();
    }

    @GET
    @Path("/gyms/registered")
    public Response viewRegisteredGyms(@QueryParam("userId") String userId) {
        List<FlipFitCentre> centres = ownerService.viewRegisteredGymCenters(userId);
        return Response.ok(centres).build();
    }

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
