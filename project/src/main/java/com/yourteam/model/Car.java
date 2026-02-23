package com.yourteam.model;

import com.yourteam.validation.CarValidator;

public class Car {
    private final int power;
    private final int year;
    private final String model;

    private Car(Builder builder) {
        this.power = builder.power;
        this.year = builder.year;
        this.model = builder.model;
    }

    public int getPower() { return power; }
    public int getYear() { return year; }
    public String getModel() { return model; }

    public static class Builder {
        private int power;
        private int year;
        private String model;

        public Builder power(int power) {
            this.power = power;
            return this;
        }
        public Builder year(int year) {
            this.year = year;
            return this;
        }
        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public int getPower() { return power; }
        public int getYear() { return year; }
        public String getModel() { return model; }

        public Car build() {
            CarValidator.validate(this);
            return new Car(this);
        }
    }

@Override
public String toString() {
    return "Автомобиль{" +
           "Модель = '" + model + '\'' +
           ", Мощность(л/с) = " + power +
           ", Год выпуска " + year +
           '}';
}

}