package com.yourteam.util;

import com.yourteam.model.Car;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {

    @Override
    public int compare(Car a, Car b) {
        if (a.getPower() != b.getPower()) {
            return Integer.compare(a.getPower(), b.getPower());
        }
        int cmpModel = a.getModel().compareTo(b.getModel());
        if (cmpModel != 0) {
            return cmpModel;
        }
        return Integer.compare(b.getYear(), a.getYear());
    }
}
