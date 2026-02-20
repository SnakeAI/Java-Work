package com.yourteam.util;

public class Validator {
    public static boolean isValid(String model, int power, int year) {
        return model != null && !model.trim().isEmpty() 
               && power > 0 && power < 3000 
               && year > 1885 && year < 2026;
    }
}
