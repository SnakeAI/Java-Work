package com.yourteam.util;

import com.yourteam.model.Car;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {

    @Override
    public int compare(Car a, Car b) {
        if (a.power != b.power) {
            return Integer.compare(a.power, b.power);
        }
        int cmpModel = a.model.compareTo(b.model);
        if (cmpModel != 0) {
            return cmpModel;
        }
        return Integer.compare(b.year, a.year);
    }
}
