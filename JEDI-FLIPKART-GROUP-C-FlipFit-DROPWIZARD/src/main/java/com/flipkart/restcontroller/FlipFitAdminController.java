package com.flipkart.restcontroller;

import com.flipkart.app.App;
import com.flipkart.business.FlipFitAdminService;
import com.flipkart.bean.FlipFitCentre;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.exception.InvalidGymException;
import com.flipkart.exception.InvalidGymOwnerException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FlipFitAdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlipFitAdminController.class);
    private final FlipFitAdminService adminService = new FlipFitAdminService();

    /**
     * Retrieves a list of pending gym centres for approval.
     *
     * @return A Response containing a list of pending FlipFitCentre objects.
     */
    @GET
    @Path("/pendingCentres")
    public Response viewPendingCentre() {
        List<FlipFitCentre> centres = adminService.displayPendingCentres();
        LOGGER.debug("Debug");
        return Response.ok(centres).build();
    }

    /**
     * Retrieves a list of pending gym owners for approval.
     *
     * @return A Response containing a list of pending FlipFitGymOwner objects.
     */
    @GET
    @Path("/pendingOwners")
    public Response viewPendingOwner() {
        List<FlipFitGymOwner> owners = adminService.displayPendingOwners();
        return Response.ok(owners).build();
    }

    /**
     * Approves a gym centre identified by the given gymId.
     *
     * @param gymId The ID of the gym centre to approve.
     * @return A Response indicating the result of the approval operation.
     */
    @POST
    @Path("/approveCentre/{gymId}")
    public Response approveCentre(@PathParam("gymId") String gymId) {
        try {
            adminService.approveGym(gymId);
            return Response.ok("Gym Centre Approved Successfully.").build();
        } catch (InvalidGymException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error: Invalid Gym Centre ID.")
                    .build();
        }
    }

    /**
     * Approves a gym owner identified by the given ownerId.
     *
     * @param ownerId The ID of the gym owner to approve.
     * @return A Response indicating the result of the approval operation.
     */
    @POST
    @Path("/approveOwner/{ownerId}")
    public Response approveOwner(@PathParam("ownerId") String ownerId) {
        try {
            adminService.approveOwner(ownerId);
            return Response.ok("Gym Owner Approved Successfully.").build();
        } catch (InvalidGymOwnerException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error: Invalid Gym Owner ID.")
                    .build();
        }
    }

    /**
     * Rejects a gym centre identified by the given gymId.
     *
     * @param gymId The ID of the gym centre to reject.
     * @return A Response indicating the result of the rejection operation.
     */
    @POST
    @Path("/rejectCentre/{gymId}")
    public Response rejectCentre(@PathParam("gymId") String gymId) {
        try {
            adminService.rejectGym(gymId);
            return Response.ok("Gym Centre Rejected Successfully.").build();
        } catch (InvalidGymException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error: Invalid Gym Centre ID.")
                    .build();
        }
    }

    /**
     * Rejects a gym owner identified by the given ownerId.
     *
     * @param ownerId The ID of the gym owner to reject.
     * @return A Response indicating the result of the rejection operation.
     */
    @POST
    @Path("/rejectOwner/{ownerId}")
    public Response rejectOwner(@PathParam("ownerId") String ownerId) {
        try {
            adminService.rejectOwner(ownerId);
            return Response.ok("Gym Owner Rejected Successfully.").build();
        } catch (InvalidGymOwnerException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error: Invalid Gym Owner ID.")
                    .build();
        }
    }

    /**
     * Removes a gym centre identified by the given gymId.
     *
     * @param gymId The ID of the gym centre to remove.
     * @return A Response indicating the result of the removal operation.
     */
    @DELETE
    @Path("/removeCentre/{gymId}")
    public Response removeCentre(@PathParam("gymId") String gymId) {
        try {
            adminService.removeGym(gymId);
            return Response.ok("Gym Centre Removed Successfully.").build();
        } catch (InvalidGymException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error: Invalid Gym Centre ID.")
                    .build();
        }
    }

    /**
     * Removes a gym owner identified by the given ownerId.
     *
     * @param ownerId The ID of the gym owner to remove.
     * @return A Response indicating the result of the removal operation.
     */
    @DELETE
    @Path("/removeOwner/{ownerId}")
    public Response removeOwner(@PathParam("ownerId") String ownerId) {
        try {
            adminService.removeOwner(ownerId);
            return Response.ok("Gym Owner Removed Successfully.").build();
        } catch (InvalidGymOwnerException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error: Invalid Gym Owner ID.")
                    .build();
        }
    }
}
