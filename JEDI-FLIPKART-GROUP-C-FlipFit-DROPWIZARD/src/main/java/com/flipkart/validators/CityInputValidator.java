package com.flipkart.validators;

import static com.flipkart.constants.CityConstants.CITY_LIST;

public class CityInputValidator extends Exception {

    /**
     * Constructs a new CityInputValidator with the specified detail message.
     *
     * @param message the detail message which will be saved for later retrieval by the {@link #getMessage()} method
     */
    public CityInputValidator(String message) {
        super(message);
    }

    /**
     * Validates if the given city name is present in the predefined list of valid cities.
     * If the city name is not found in the list, throw  a CityInputValidator exception
     *
     * @param city the name of the city to validate
     * @throws CityInputValidator if the city is not found in the predefined list
     */
    public static void validateCityName(String city) throws CityInputValidator {
        CITY_LIST.stream()
                .filter(_city -> _city.equals(city))
                .findFirst()
                .orElseThrow(() -> new CityInputValidator("Invalid city"));
    }
}
