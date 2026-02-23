package com.yourteam.validation;

import com.yourteam.model.Car;

public final class CarValidator {
    private static final int MIN_POWER = 1;
    private static final int MAX_POWER = 2999;
    private static final int MIN_YEAR = 1886;
    private static final int MAX_YEAR = 2026;

    private CarValidator() {}

    public static void validate(Car.Builder b) {
        if (b.getPower() < MIN_POWER || b.getPower() > MAX_POWER) {
            throw new IllegalStateException("Power must be between " + MIN_POWER + " and  " + MAX_POWER);
        }
        if (b.getYear() < MIN_YEAR || b.getYear() > MAX_YEAR) {
            throw new IllegalStateException("Year is invalid");
        }
        if (b.getModel() == null || b.getModel().isBlank()) {
            throw new IllegalStateException("Model is required");
        }
    }

    public static boolean isValid(String model, int power, int year) {
        return model != null && !model.isBlank() &&
               power >= MIN_POWER && power <=MAX_POWER &&
               year >= MIN_YEAR && year <= MAX_YEAR;
    }
}
