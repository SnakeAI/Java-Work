package com.yourteam;

import java.nio.file.Paths;
import java.util.Scanner;

import com.yourteam.io.CarFileReader;
import com.yourteam.io.CarInput;
import com.yourteam.io.CarProvider;
import com.yourteam.io.CarRandomGenerator;
import com.yourteam.model.Car;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Программа для работы с данными автомобилей ===");

        while (true) {
            printMenu();
            int choice = getMenuChoice();
            if (choice == 4) break;

            // Полиморфизм в действии: работаем с интерфейсом, а не реализацией
            CarProvider provider = null;

            switch (choice) {
                case 1:
                    System.out.print("Введите путь к CSV (или Enter для 'cars.csv'): ");
                    String path = scanner.nextLine();
                    provider = new CarFileReader(Paths.get(path.isEmpty() ? "cars.csv" : path));
                    break;
                case 2:
                    int countGen = getCount("Сколько сгенерировать?");
                    if (countGen > 0) provider = new CarRandomGenerator(countGen);
                    break;
                case 3:
                    int countInp = getCount("Сколько ввести вручную?");
                    if (countInp > 0) provider = new CarInput(scanner, countInp);
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }

            if (provider != null) {
                Car[] cars = provider.read(); // Универсальный вызов
                if (cars.length > 0) {
                    printCars(cars);
                } else {
                    System.out.println("1Данные не получены.");
                }
            }
        }
        System.out.println("Программа завершена.");
    }

    private static void printMenu() {
        System.out.println("\n1. Из CSV | 2. Случайно | 3. Вручную | 4. Выход");
        System.out.print("Ваш выбор: ");
    }

    private static int getMenuChoice() {
        try { return Integer.parseInt(scanner.nextLine()); } 
        catch (NumberFormatException e) { return 0; }
    }

    private static int getCount(String message) {
        System.out.print(message + " ");
        try { return Integer.parseInt(scanner.nextLine()); } 
        catch (NumberFormatException e) { return -1; }
    }

    private static void printCars(Car[] cars) {
        System.out.println("\n" + "=".repeat(50));
        System.out.printf("%-10s %-20s %-10s%n", "Мощность", "Модель", "Год");
        for (Car car : cars) {
            System.out.printf("%-10d %-20s %-10d%n", car.getPower(), car.getModel(), car.getYear());
        }
        System.out.println("=".repeat(50));
    }
}