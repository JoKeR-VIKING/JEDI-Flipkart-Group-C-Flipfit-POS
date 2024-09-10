package com.flipkart.restcontroller;

import com.flipkart.bean.FlipFitUser;
import com.flipkart.business.FlipFitCustomerService;
import com.flipkart.business.FlipFitGymOwnerService;
import com.flipkart.business.FlipFitUserService;
import com.flipkart.enums.RoleEnum;
import com.flipkart.exception.ExistingUserException;
import com.flipkart.exception.InvalidPasswordException;
import com.flipkart.exception.InvalidUserException;
import com.flipkart.validators.CustomerInputValidator;
import com.flipkart.validators.GymOwnerValidator;

import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static com.flipkart.utils.Helper.parseDate;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FlipFitUserController {

    private final FlipFitCustomerService customerService = new FlipFitCustomerService();
    private final FlipFitGymOwnerService ownerService = new FlipFitGymOwnerService();
    private final FlipFitUserService userService = new FlipFitUserService();

    @POST
    @Path("/login")
    public Response login(@QueryParam("username") @NotBlank String username,
                          @QueryParam("password") @NotBlank String password) {
        try {
            FlipFitUser user = userService.authenticate(username, password);
            if (user != null) {
                Map<String, String> response = new HashMap<>();

                response.put("message", "Login successful");
                response.put("role", user.getRole().toString());
                response.put("date", LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                response.put("time", LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                return Response.ok(response).build();
            }
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials").build();
        } catch (InvalidPasswordException | InvalidUserException e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/register")
    public Response registerUser(@QueryParam("username") @NotNull @NotBlank String username,
                                 @QueryParam("password") @NotNull @NotBlank String password,
                                 @QueryParam("name") @NotNull @NotBlank String name,
                                 @QueryParam("address") @NotNull @NotBlank String address,
                                 @QueryParam("phoneNumber") @NotNull @NotBlank @Pattern(regexp = "\\d{10}") String phoneNumber,
                                 @QueryParam("role") @NotNull RoleEnum role,
                                 @QueryParam("panNumber") @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}") String panNumber,
                                 @QueryParam("gstNumber") String gstNumber,
                                 @QueryParam("age") @Min(0) @Max(150) int age,
                                 @QueryParam("gender") @Pattern(regexp = "male|female|others") String gender,
                                 @QueryParam("weight") @DecimalMin("0.0") double weight,
                                 @QueryParam("dob") @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}") String dob) {
        try {
            if (userService.userExists(username)) {
                return Response.status(Response.Status.CONFLICT).entity("User already exists").build();
            }

            switch (role) {
                case GYM_OWNER:
                    GymOwnerValidator.validatePanCardNumber(panNumber);
                    GymOwnerValidator.validateGstNumber(panNumber, gstNumber);
                    ownerService.createProfile(
                            username, password, name, address, phoneNumber, gstNumber, panNumber
                    );
                    break;
                case CUSTOMER:
                    CustomerInputValidator.validateAge(age);
                    CustomerInputValidator.validateGender(gender);
                    CustomerInputValidator.validateWeight(weight);
                    CustomerInputValidator.validateDob(dob, age);
                    customerService.createProfile(
                            username, password, name, address, phoneNumber, weight, age, gender,
                            parseDate(dob)
                    );
                    break;
                default:
                    return Response.status(Response.Status.BAD_REQUEST).entity("Invalid role").build();
            }

            return Response.ok("User registered successfully").build();
        } catch (ExistingUserException e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        } catch (GymOwnerValidator | CustomerInputValidator e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/change-password")
    public Response changePassword(@QueryParam("username") @NotNull @NotBlank String username,
                                   @QueryParam("oldPassword") @NotNull @NotBlank String oldPassword,
                                   @QueryParam("newPassword") @NotNull @NotBlank String newPassword,
                                   @QueryParam("confirmNewPassword") @NotNull @NotBlank String confirmNewPassword) {
        try {
            FlipFitUser user = userService.authenticate(username, oldPassword);

            userService.changePassword(user.getUserId(), newPassword);
            return Response.ok("Password changed successfully").build();
        } catch (InvalidUserException e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid User").build();
        } catch (InvalidPasswordException e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid password").build();
        }
    }
}
