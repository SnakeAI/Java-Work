package com.yourteam;

import com.yourteam.io.CarFileReader;
import com.yourteam.io.CarManualinput;
import com.yourteam.io.CarRandomGenerator;
import com.yourteam.model.Car;
import com.yourteam.strategy.QuickSort;

import java.nio.file.Path;
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
            switch (choice)   {
                case "1" -> handleManualinput(scanner);
                case "2" -> handleFileinput(scanner);
                case "3" -> handleRandominput(scanner);
                case "0" -> running = false;
                default -> System.out.println("Неверный выбор. Попробуйте еще раз");

            }


        }

        System.out.println("Работа завершена.");
    }


    private static void handleManualinput(Scanner scanner){

        int lenght = askArrayLength(scanner);
        Car[] cars = new CarManualinput().read(scanner, lenght);
        runSortingFlow(cars);

    }


    private static void handleFileinput(Scanner scanner){
        System.out.println("Вставьте путь к файлу: ");
        String path = scanner.nextLine().trim();
        Car[] cars = new CarFileReader().read(Path.of(path));
        runSortingFlow(cars);

    }


    private static void handleRandominput(Scanner scanner){
        int length = askArrayLength(scanner);
        Car[] cars = new CarRandomGenerator().generate(length);
        runSortingFlow(cars);

    }

    
    private static int askArrayLength(Scanner scanner){
        while(true){
            System.out.println("Введите длину массива: ");
            String input = scanner.nextLine().trim();
            try {
                int length = Integer.parseInt(input);
                if (length > 0) {
                    return length;
                }
                System.out.println("Длина дожна быть больше 0");

                } catch (NumberFormatException ex) {
                    System.out.println("Введите целое число:");
                }
            }
        }


    private static void runSortingFlow(Car[] cars) {
        if(cars.length == 0){
            System.out.println("Массив пуст");
            return;
        }

        new QuickSort().sort(cars, null);
        System.out.println("\nОтсортированный массив:");
        for (Car car : cars){
            System.out.println(car);
        }

    }

}






