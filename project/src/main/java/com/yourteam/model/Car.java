package com.yourteam.model;

public class Car {
    private int power, year;
    private String model;

    private Car(Builder builder) {
        this.power = builder.power;
        this.year = builder.year;
        this.model = builder.model;
    }
    public int getPower() { return power; }
    public int getYear() { return year; }
    public String getModel() { return model; }

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
    }
}

