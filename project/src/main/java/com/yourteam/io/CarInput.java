package com.yourteam.io;

import java.util.Scanner;

import com.yourteam.model.Car;
import com.yourteam.util.Validator;

public class CarInput implements CarProvider {
    private final Scanner scanner;
    private final int length;

    public CarInput(Scanner scanner, int length) {
        this.scanner = scanner;
        this.length = length;
    }

    @Override
    public Car[] read() {
        Car[] cars = new Car[length];
        for (int i = 0; i < length; i++) {
            System.out.println("\n=== Enter Car #" + (i + 1) + " ===");
            
            String model;
            int power = 0;
            int year = 0;

            while (true) {
                try {
                    System.out.print("Enter power: ");     
                    power = Integer.parseInt(scanner.nextLine().trim());
                    
                    System.out.print("Enter model: ");
                    model = scanner.nextLine().trim();
                    
                    System.out.print("Enter year: ");
                    year = Integer.parseInt(scanner.nextLine().trim());

                    if (Validator.isValid(model, power, year)) {
                        cars[i] = new Car.Builder()
                                .power(power)
                                .model(model)
                                .year(year)
                                .build();
                        System.out.println("Car Add!");
                        break;
                    } else {
                        System.out.println("Error Validate");
                        System.out.println("Model not empty, power 1-2999, year 1886-2026");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error power and year integer");
                }
            }
        }
        return cars;
    }
}