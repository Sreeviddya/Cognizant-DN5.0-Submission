package com.cognizant.countryservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.countryservice.model.Country;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    private List<Country> countries;

    @PostConstruct
    private void init() {
        LOGGER.info("Start");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        countries = new ArrayList<>(context.getBeansOfType(Country.class).values());
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End");
    }

    public Country getCountry(String code) {
        return countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}
