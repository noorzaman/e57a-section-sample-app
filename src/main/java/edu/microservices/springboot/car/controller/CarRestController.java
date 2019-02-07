package edu.microservices.springboot.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.microservices.springboot.car.model.Car;
import edu.microservices.springboot.car.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarRestController {

	@Autowired
	private CarService carService;

	/*
	 * Using @RequestParam
	 */
	@RequestMapping(value = "/attributes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Car>> getCarsByColor(@RequestParam(value = "color", required = true) String color) {
		List<Car> cars = carService.findByColor(color);
		if (cars.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	}

	/*
	 * Using @PathVariable
	 */
	@RequestMapping(value = "/make/{make}/color/{color}", method = RequestMethod.GET)
	public ResponseEntity<Car> getPing(@PathVariable("make") String make, @PathVariable("color") String color) {
		Car car = new Car();
		car.setMake(make);
		car.setColor(color);
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> update() {
		return new ResponseEntity<String>("PUT update success", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody Car car) {
		System.out.println("Create car: " + car);
		return new ResponseEntity<String>("POST insert success", HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete() {
		return new ResponseEntity<String>("DELETE success", HttpStatus.OK);
	}

}
