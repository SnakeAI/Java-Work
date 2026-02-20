package com.yourteam.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.yourteam.model.Car;
import com.yourteam.util.Validator;

public class CarFileReader implements CarProvider {
    private final Path path;

    public CarFileReader(Path path) {
        this.path = path;
    }

    @Override
    public Car[] read() {
        List<Car> carList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            boolean isFirstLine = true; 
            
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; 
                }
                
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    try {
                        int power = Integer.parseInt(parts[0].trim());
                        String model = parts[1].trim();
                        int year = Integer.parseInt(parts[2].trim());

                        if (Validator.isValid(model, power, year)) {
                            carList.add(new Car.Builder()
                                    .power(power)  
                                    .model(model)   
                                    .year(year)      
                                    .build());
                        }
                    } catch (NumberFormatException ignored) {} 
                }
            }
        } catch (IOException e) {
            System.out.println("Error reader " + e.getMessage());
        }
        return carList.toArray(new Car[0]);
    }
}
