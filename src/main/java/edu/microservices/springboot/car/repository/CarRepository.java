package edu.microservices.springboot.car.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.microservices.springboot.car.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

	List<Car> findByColorIgnoreCase(String color);

}