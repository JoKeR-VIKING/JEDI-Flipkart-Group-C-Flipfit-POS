package com.flipkart.restcontroller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/admin")
public class FlipFitAdminController {
    @GET
    @Path("/")
    public String helloWord() {
        return "hello world";
    }
}