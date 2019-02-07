package edu.microservices.springboot.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import edu.microservices.springboot.car.model.Car;
import edu.microservices.springboot.car.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	private CarRepository carRepository;

	@Override
	public List<Car> findByColor(String color) {
		return carRepository.findByColorIgnoreCase(StringUtils.trimWhitespace(color));
	}

	@Override
	public Car saveCar(Car car) {
		return carRepository.save(car);
	}
}
