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
	@RequestMapping(value = "/{carId}", method = RequestMethod.GET)
	public ResponseEntity<Car> getCarById(@PathVariable("carId") Long carId) {

		// STUB service method to find car by car Id
		Car car = new Car();
		car.setId(carId);
		car.setMake("Honda");
		car.setColor("black");

		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}

	/*
	 * Example PUT
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> updateCar(@RequestBody Car car) {
		System.out.println("Updating car with: " + car);
		// STUB service method to update car
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}

	/*
	 * Example POST
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addNewCar(@RequestBody Car car) {
		System.out.println("Creating car with: " + car);
		// STUB service method to create car
		return new ResponseEntity<Car>(car, HttpStatus.CREATED);
	}

	/*
	 * Example DELETE
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> deleteCar() {
		// STUB service method to delete car
		return new ResponseEntity<String>("DELETE success", HttpStatus.OK);
	}

}
