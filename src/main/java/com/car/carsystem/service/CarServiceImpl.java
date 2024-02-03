package com.car.carsystem.service;

import com.car.carsystem.model.Car;
import com.car.carsystem.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CarServiceImpl implements CarService{
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public void deleteCarById(int id) {
        carRepository.deleteById(id);
    }

    @Override
    public Optional<Car> onecar(int id) {
        return carRepository.findById(id);
    }


    @Override
    public Car updateCar(int id, Car updatedCar) {
        Optional<Car> existingCarOptional = carRepository.findById(id);

        if (existingCarOptional.isPresent()) {
            Car existingCar = existingCarOptional.get();
            existingCar.setCar_type(updatedCar.getCar_type());
            existingCar.setCar_no(updatedCar.getCar_no());
            existingCar.setFirst_name(updatedCar.getFirst_name());
            existingCar.setLast_name(updatedCar.getLast_name());
            existingCar.setServiceType(updatedCar.getServiceType());
            existingCar.setPhone_number(updatedCar.getPhone_number());
            existingCar.setPrice(updatedCar.getPrice());


            return carRepository.save(existingCar);
        } else {

            throw new RuntimeException("Car not found with ID: " + id);
        }
    }
    }

