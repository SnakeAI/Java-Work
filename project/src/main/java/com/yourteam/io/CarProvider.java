package com.yourteam.io;
import com.yourteam.model.Car;

import java.util.List;

public interface CarProvider {
    List<Car> read();
}