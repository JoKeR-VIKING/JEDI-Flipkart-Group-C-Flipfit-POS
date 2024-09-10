package com.flipkart.restcontroller;

import com.flipkart.bean.*;
import com.flipkart.business.*;
import com.flipkart.exception.*;
import com.flipkart.validators.*;

import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;

import static com.flipkart.constants.CityConstants.CITY_LIST;
import static com.flipkart.utils.Helper.parseDate;
import static com.flipkart.utils.Helper.parseYearMonth;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
public class FlipFitCustomerController {

    private final FlipFitCustomerService customerService = new FlipFitCustomerService();
    private final FlipFitSlotBookingService bookingService = new FlipFitSlotBookingService();
    private final FlipFitAdminService adminService = new FlipFitAdminService();
    private final FlipFitGymOwnerService ownerService = new FlipFitGymOwnerService();
    private final FlipFitPaymentsService paymentService = new FlipFitPaymentsService();

    @GET
    @Path("/cities")
    public Response viewCityList() {
        // Assuming CITY_LIST is a static list of cities
        return Response.ok(CITY_LIST).build();
    }

    @GET
    @Path("/gyms")
    public Response viewCentresByCity(@QueryParam("city") @NotNull @Size(min = 1) String city) {
        try {
            CityInputValidator.validateCityName(city);
            List<FlipFitCentre> gyms = customerService.getCentreListByCity(city);
            return Response.ok(gyms).build();
        } catch (CityInputValidator e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid City").build();
        }
    }

    @PUT
    @Path("/profile")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editProfile(
            @QueryParam("userId") @NotNull String userId,
            @QueryParam("address") @Size(min = 1) String address,
            @QueryParam("weight") @Min(0) double weight,
            @QueryParam("age") @Min(0) int age,
            @QueryParam("gender") @Size(min = 1) String gender,
            @QueryParam("dob") @Size(min = 10, max = 10) String dob
    ) {
        try {
            CustomerInputValidator.validateAge(age);
            CustomerInputValidator.validateGender(gender);
            CustomerInputValidator.validateWeight(weight);
            CustomerInputValidator.validateDob(dob, age);

            customerService.editProfile(userId, address, weight, age, gender, parseDate(dob));
            return Response.ok("User edited successfully").build();
        } catch (InvalidUserException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid User").build();
        } catch (CustomerInputValidator e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/gyms/all")
    public Response viewAllGyms() {
        List<FlipFitCentre> gyms = adminService.displayAllRegisteredCentres();
        return Response.ok(gyms).build();
    }

    @GET
    @Path("/slots/available")
    public Response viewAvailableSlots(@QueryParam("gymId") @NotBlank String gymId, @QueryParam("date") @NotBlank String date) {
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

    @POST
    @Path("/book")
    public Response bookSlot(
            @QueryParam("userId") @NotNull String userId,
            @QueryParam("slotId") @NotNull String slotId,
            @QueryParam("bookingDate") @NotNull @Size(min = 10, max = 10) String bookingDate,
            @QueryParam("cardNumber") @NotNull @Size(min = 16, max = 16) String cardNumber,
            @QueryParam("cvv") @NotNull @Size(min = 3, max = 3) String cvv,
            @QueryParam("cardExpiry") @NotNull @Size(min = 5, max = 5) String cardExpiry
    ) {
        try {
            BookSlotInputValidator.validateDateFormat(bookingDate);
            BookSlotInputValidator.validateFutureDate(bookingDate);
            FlipFitCenterSlot slot = ownerService.getSlot(slotId);

            if (slot == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Slot is full/doesn't exist").build();
            }

            // Process payment
            FlipFitPayments payment = paymentService.makePayment(
                    userId,
                    500.00,
                    cardNumber,
                    cvv,
                    parseYearMonth(cardExpiry),
                    LocalDate.now()
            );

            bookingService.bookSlot(userId, parseDate(bookingDate), slot, payment.getPaymentId());
            return Response.ok("Payment successful, slot booked!").build();
        } catch (BookSlotInputValidator | InvalidSlotException | GymSlotSeatLimitReachedException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/bookings")
    public Response viewBookings(@QueryParam("userId") @NotNull String userId) {
        List<FlipFitSlotBooking> bookings = bookingService.listBookings(userId);
        if (bookings.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No bookings found").build();
        } else {
            return Response.ok(bookings).build();
        }
    }

    @DELETE
    @Path("/bookings")
    public Response cancelCustomerBooking(@QueryParam("bookingId") @NotNull String bookingId) {
        try {
            bookingService.cancelBooking(bookingId);
            return Response.ok("Booking cancelled!").build();
        } catch (InvalidBookingException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid booking").build();
        }
    }
}
