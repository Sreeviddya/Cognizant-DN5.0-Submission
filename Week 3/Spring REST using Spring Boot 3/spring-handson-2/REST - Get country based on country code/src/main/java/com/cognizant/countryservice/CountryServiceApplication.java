package com.cognizant.countryservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountryServiceApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CountryServiceApplication.class, args);
        LOGGER.info("Inside main");
    }
}
