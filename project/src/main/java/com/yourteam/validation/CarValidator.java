package com.yourteam.validation;

public final class CarValidation {
    private CarValidation() {}

    public static void validate(Car.Builder b) {
        if (b.power <= 0) {
            throw new IllegalStateException("Power must be > 0");
        }
        if (b.year < 1900 || b.year > 2027) {
            throw new IllegalStateException("Year is invalid");
        }
        if (b.model == null || b.model.isBlank()) {
            throw new IllegalStateException("Model is required");
        }
    }
}

