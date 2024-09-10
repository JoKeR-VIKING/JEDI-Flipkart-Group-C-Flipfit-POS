package com.flipkart.app;

import com.flipkart.restcontroller.FlipFitCustomerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.flipkart.restcontroller.FlipFitAdminController;

public class App extends Application<Configuration>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        e.jersey().register(new FlipFitAdminController());
        e.jersey().register(new FlipFitCustomerController());
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}