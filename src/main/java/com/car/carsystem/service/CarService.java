package com.car.carsystem.service;

import com.car.carsystem.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    public Car saveCar(Car car);
    public List<Car> getAllCars();
    void deleteCarById(int id);

    Optional<Car> onecar(int id);
    Car updateCar(int id, Car updatedCar);
}

