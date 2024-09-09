package com.flipkart.validators;

import static com.flipkart.constants.CityConstants.CITY_LIST;

public class CityInputValidator extends Exception {

    public CityInputValidator(String message) {
        super(message);
    }

    public static void validateCityName(String city) throws CityInputValidator {
        CITY_LIST.stream()
                .filter(_city -> _city.equals(city))
                .findFirst()
                .orElseThrow(() -> new CityInputValidator("Invalid date format"));
    }
}
