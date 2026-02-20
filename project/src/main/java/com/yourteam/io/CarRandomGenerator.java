package com.yourteam.io;

import java.util.Random;

import com.yourteam.model.Car;

public class CarRandomGenerator implements CarProvider {
    private static final String[] MODELS = {"Audi", "Toyota", "Ford", "Mazda", "Tesla", "Lada"};
    private final int length;
    private final Random random = new Random();

    public CarRandomGenerator(int length) {
        this.length = length;
    }

    @Override
    public Car[] read() {
        Car[] cars = new Car[length];
        for (int i = 0; i < length; i++) {
            cars[i] = new Car.Builder()
                    .model(MODELS[random.nextInt(MODELS.length)])
                    .power(50 + random.nextInt(500))
                    .year(1990 + random.nextInt(37))
                    .build();
        }
        return cars;
    }
}

