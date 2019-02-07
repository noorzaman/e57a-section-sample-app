package edu.microservices.springboot.car.service;

import java.util.List;

import edu.microservices.springboot.car.model.Car;

public interface CarService {

	List<Car> findByColor(String color);

	Car saveCar(Car car);

}
