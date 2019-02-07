package edu.microservices.springboot.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.microservices.springboot.car.model.Car;
import edu.microservices.springboot.car.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarRestController {

	@Autowired
	private CarService carService;

	@RequestMapping(value = "/attributes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Car>> getCarsByColor(@RequestParam(value = "color", required = true) String color) {
		List<Car> cars = carService.findByColor(color);
		if (cars.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	}

}
