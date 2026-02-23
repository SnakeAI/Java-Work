package com.yourteam.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yourteam.model.Car;
import com.yourteam.validation.CarValidator;

public class CarManualInput implements CarProvider {
    private final Scanner scanner;
    private final int length;

    public CarManualInput(Scanner scanner, int length) {
        this.scanner = scanner;
        this.length = length;
    }

    @Override
    public List<Car> read() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            System.out.println("\nВведите Авто №" + (i + 1));
            
            String model;
            int power = 0;
            int year = 0;

            while (true) {
                try {
                    System.out.print("Введите мощность(1-2999 л/с): ");
                    power = Integer.parseInt(scanner.nextLine().trim());
                    
                    System.out.print("Введите модель: ");
                    model = scanner.nextLine().trim();
                    
                    System.out.print("Введите год(Год выпуска 1886-2026): ");
                    year = Integer.parseInt(scanner.nextLine().trim());

                    if (CarValidator.isValid(model, power, year)) {
                        cars.add(new Car.Builder()
                                .power(power)
                                .model(model)
                                .year(year)
                                .build());
                        System.out.println("Автомобили добавлены!");
                        break;
                    } else {
                        System.out.println("Ошибка ввода");
                        System.out.println("Модель не должна пустовать, Мощность 1-2999, Год выпуска 1886-2026");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка! Ввод мощности и года выпуска вводиться в цифрах");
                }
            }
        }
        return cars;
    }
}