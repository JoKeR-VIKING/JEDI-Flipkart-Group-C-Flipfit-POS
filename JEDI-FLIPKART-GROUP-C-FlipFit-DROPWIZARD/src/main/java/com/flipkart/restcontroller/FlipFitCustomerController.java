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

    /**
     * Retrieves a list of all available cities.
     * This method returns a static list of cities defined in `CITY_LIST`.
     *
     * @return a {@link Response} containing a list of cities
     */
    @GET
    @Path("/cities")
    public Response viewCityList() {
        // Assuming CITY_LIST is a static list of cities
        return Response.ok(CITY_LIST).build();
    }

    /**
     * Retrieves a list of gyms located in a specified city.
     * This method validates the city name before fetching the list of gyms from the service.
     * If the city name is invalid, an appropriate error message is returned.
     *
     * @param city the name of the city for which gyms are to be retrieved
     * @return a {@link Response} containing a list of {@link FlipFitCentre} objects or an error message
     */
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

    /**
     * Updates the profile information for a specific user.
     * This method validates the input data including age, gender, weight, and date of birth
     * before updating the user's profile with the new details.
     * If any input data is invalid or the user ID is not found, an appropriate error message is returned.
     *
     * @param userId the ID of the user whose profile is being updated
     * @param address the new address of the user
     * @param weight the new weight of the user
     * @param age the new age of the user
     * @param gender the new gender of the user
     * @param dob the new date of birth of the user, in the format "yyyy-MM-dd"
     * @return a {@link Response} indicating the result of the profile update
     */
    @POST
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
            return Response.ok().build();
        } catch (CustomerInputValidator | InvalidUserException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    /**
     * Retrieves a list of all registered gyms.
     * This method fetches and returns a list of all gyms registered in the system.
     *
     * @return a {@link Response} containing a list of {@link FlipFitCentre} objects
     */
    @GET
    @Path("/gyms/all")
    public Response viewAllGyms() {
        List<FlipFitCentre> gyms = adminService.displayAllRegisteredCentres();
        return Response.ok(gyms).build();
    }

    /**
     * Retrieves a list of all available slots.
     * This method currently does not implement the logic to fetch available slots and returns a null response.
     *
     * @return a {@link Response} containing a list of slots or a null response
     */
    @GET
    @Path("/slots")
    public Response viewAvailableSlots() {
//        List<FlipFitCenterSlot> slots = ownerService.viewAvailableSlots();
        return Response.ok(null).build();
    }

    /**
     * Books a slot for a user on a specified date.
     * This method validates the booking date, payment information, and checks if the slot exists before processing the booking.
     * If the slot is full or does not exist, or if there are validation errors, an appropriate error message is returned.
     *
     * @param userId the ID of the user making the booking
     * @param slotId the ID of the slot being booked
     * @param bookingDate the date for which the slot is being booked, in the format "yyyy-MM-dd"
     * @param cardNumber the credit card number used for payment
     * @param cvv the CVV of the credit card used for payment
     * @param cardExpiry the expiry date of the credit card, in the format "MM/yyyy"
     * @return a {@link Response} indicating the result of the booking process
     */
    @POST
    @Path("/book")
    public Response bookSlot(
            @QueryParam("userId") @NotNull String userId,
            @QueryParam("slotId") @NotNull String slotId,
            @QueryParam("bookingDate") @NotNull @Size(min = 10, max = 10) String bookingDate,
            @QueryParam("cardNumber") @NotNull @Size(min = 16, max = 16) String cardNumber,
            @QueryParam("cvv") @NotNull @Size(min = 3, max = 3) String cvv,
            @QueryParam("cardExpiry") @NotNull @Size(min = 7, max = 7) String cardExpiry
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

    /**
     * Retrieves a list of bookings made by a specific user.
     * This method fetches and returns all bookings for the given user ID.
     * If no bookings are found, an appropriate message is returned.
     *
     * @param userId the ID of the user whose bookings are to be retrieved
     * @return a {@link Response} containing a list of {@link FlipFitSlotBooking} objects or an error message
     */
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

    /**
     * Cancels a specific booking.
     * This method attempts to cancel a booking based on the provided booking ID.
     * If the booking ID is invalid, an appropriate error message is returned.
     *
     * @param bookingId the ID of the booking to be cancelled
     * @return a {@link Response} indicating the result of the cancellation
     */
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
