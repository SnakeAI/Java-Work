package com.yourteam.model;

public class Car {
    private final int power, year;
    private final String model;

    private Car(Builder builder) {
        this.power = builder.power;
        this.year = builder.year;
        this.model = builder.model;
    }
    public int getPower() { return power; }
    public int getYear() { return year; }
    public String getModel() { return model; }

    @Override
    public String toString() {
        return String.format("Car{power=%d, model='%s', year=%d}", power, model, year);
    }

    public static class Builder {
        private int power, year;
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

        public Car build() {
            return new Car(this);
        }
    }
}
