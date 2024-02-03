package com.car.carsystem.repository;

import com.car.carsystem.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
    void deleteById(int id);
    Optional<Car> findById(int id);
}
