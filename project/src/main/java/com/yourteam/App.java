package com.yourteam;

import com.yourteam.io.CarFileReader;
import com.yourteam.io.CarInput;
import com.yourteam.io.CarProvider;
import com.yourteam.io.CarRandomGenerator;
import com.yourteam.model.Car;
import com.yourteam.strategy.QuickSort;
import com.yourteam.util.CarComparator;

import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Меню");
            System.out.println("1. Ввести массив вручную");
            System.out.println("2. Считать массив из файла");
            System.out.println("3. Сгенерировать случайный массив");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> handleManualInput(scanner);
                case "2" -> handleFileInput(scanner);
                case "3" -> handleRandomInput(scanner);
                case "0" -> running = false;
                default -> System.out.println("Неверный выбор. Попробуйте еще раз");
            }
        }

        System.out.println("Работа завершена.");
    }

    private static void handleManualInput(Scanner scanner) {
        int length = askArrayLength(scanner);
        CarProvider provider = new CarInput(scanner, length);
        List<Car> cars = provider.read();
        runSortingFlow(cars);
    }

    private static void handleFileInput(Scanner scanner) {
        System.out.print("Введите путь к файлу: ");
        String path = scanner.nextLine().trim();
        Path filePath = Path.of("cars.csv");
        CarProvider provider = new CarFileReader(filePath);
        List<Car> cars = provider.read();
        runSortingFlow(cars);
    }

    private static void handleRandomInput(Scanner scanner) {
        int length = askArrayLength(scanner);
        CarProvider provider = new CarRandomGenerator(length);
        List<Car> cars = provider.read();
        runSortingFlow(cars);
    }

    private static int askArrayLength(Scanner scanner) {
        while (true) {
            System.out.print("Введите длину массива: ");
            String input = scanner.nextLine().trim();
            try {
                int length = Integer.parseInt(input);
                if (length > 0) {
                    return length;
                }
                System.out.println("Длина должна быть больше 0");
            } catch (NumberFormatException ex) {
                System.out.println("Введите целое число:");
            }
        }
    }

    private static void runSortingFlow(List<Car> cars) {
        if (cars.isEmpty()) {
            System.out.println("Массив пуст");
            return;
        }

        Car[] array = cars.toArray(new Car[0]);
       
        new QuickSort().sort(array, new CarComparator());
        System.out.println("\nОтсортированный массив:");
        for (Car car : array) {
            System.out.println(car);   
    }
}

}
