package com.yourteam.strategy;

import com.yourteam.model.Car;

import java.util.Comparator;

public class QuickSort implements SortStrategy{

    @Override
    public void sort(Car[] cars, Comparator<Car> comparator) {
        if (cars == null || cars.length <= 1) return;
        quickSort(cars, 0, cars.length - 1, comparator);
    }

    private void quickSort(Car[] cars, int low, int high, Comparator<Car> comparator) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            Car pivot = cars[middle];
            Car temp = cars[middle];
            cars[middle] = cars[high];
            cars[high] = temp;

            int i = low;
            for (int j = low; j < high; j++) {
                if (comparator.compare(cars[j], pivot) <= 0) {
                    temp = cars[i];
                    cars[i] = cars[j];
                    cars[j] = temp;
                    i++;
                }
            }
            temp = cars[i];
            cars[i] = cars[high];
            cars[high] = temp;

            quickSort(cars, low, i - 1, comparator);
            quickSort(cars, i + 1, high, comparator);
        }
    }
}