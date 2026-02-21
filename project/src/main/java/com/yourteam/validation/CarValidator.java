package com.yourteam.validation;

import com.yourteam.model.Car;

public final class CarValidator {
    private CarValidator() {}

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

    public static boolean isValid(String model, int power, int year) {
        // Простая проверка без исключений, диапазоны взяты из подсказки в ManualInput
        return model != null && !model.isBlank() &&
               power > 0 && power < 3000 &&
               year >= 1886 && year <= 2026;
    }
}