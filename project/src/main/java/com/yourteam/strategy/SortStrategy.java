package com.yourteam.strategy;

import com.yourteam.model.Car;

import java.util.Comparator;

public interface SortStrategy {
    void sort(Car[] cars, Comparator<Car> comparator);
}