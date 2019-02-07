package edu.microservices.springboot.car.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(min = 3, max = 50)
	private String color;

	@NotNull
	@Min(1850)
	private String year;

	@NotNull
	@Size(min = 3, max = 50)
	private String make;

	@NotNull
	@Size(min = 3, max = 50)
	private String model;

	@NotNull
	@Size(min = 0, max = 500)
	private String notes;

	public Long getId() {
		return id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", color=" + color + ", year=" + year + ", make=" + make + ", model=" + model + ", notes=" + notes + "]";
	}

}
