package com.car.carsystem.controller;

import com.car.carsystem.model.Car;
import com.car.carsystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public String add(@RequestBody Car car){
        carService.saveCar(car);
        return "New Car is added";
    }

    @GetMapping("/getAll")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @DeleteMapping("deleteCar/{id}")
    public String deleteCarById(@PathVariable int id) {
        carService.deleteCarById(id);
        return "Car with ID " + id + " has been deleted.";
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<?> getCrById(@PathVariable int id) {
        Optional<Car> optionalCar = carService.onecar(id);

        if (optionalCar.isPresent()) {
            return new ResponseEntity<>(optionalCar.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Car not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCar(@PathVariable int id, @RequestBody Car updatedCar) {
        try {
            Car result = carService.updateCar(id, updatedCar);
            return new ResponseEntity<>("Car updated successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
