package com.yourteam.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.yourteam.model.Car;

public class CarRandomGenerator implements CarProvider {
    private static final String[] MODELS = {"Audi", "Toyota", "Ford", "Mazda", "Tesla", "Lada"};
    private final int length;
    private final Random random = new Random();

    private static final int MIN_POWER = 1;
    private static final int MAX_POWER = 2999;
    private static final int MIN_YEAR = 1886;
    private static final int MAX_YEAR = 2026;

    public CarRandomGenerator(int length) {
        this.length = length;
    }

    @Override
    public List<Car> read() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            cars.add(new Car.Builder()
                    .model(MODELS[random.nextInt(MODELS.length)])
                    .power(random.nextInt(MAX_POWER - MIN_POWER + 1) + MIN_POWER)
                    .year(random.nextInt(MAX_YEAR - MIN_YEAR + 1) + MIN_YEAR)
                    .build());
        }
        return cars;
    }
}