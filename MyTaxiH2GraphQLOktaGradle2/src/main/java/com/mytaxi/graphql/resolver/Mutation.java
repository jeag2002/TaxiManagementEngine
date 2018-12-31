package com.mytaxi.graphql.resolver;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.mytaxi.graphql.exception.CarNotFoundException;
import com.mytaxi.graphql.model.Car;
import com.mytaxi.graphql.repository.CarRepository;

public class Mutation implements GraphQLMutationResolver  {
	
	private CarRepository carRepository;
	
	public Mutation(CarRepository _carRepository) {
		this.carRepository = _carRepository;
	}
	
	public boolean deleteCar(Long id) {
		carRepository.deleteById(id);
		return true;
	}
	
	public Car updateCar(
			Long id,
			String licenceplate, 
			int seatCount, 
			int convertible, 
			int rating, 
			String engineType
			) {
		
		Optional<Car> carOptional = carRepository.findById(id);
		Car car = carOptional.get();
		if (car == null) {
			throw new CarNotFoundException("The car to be updated was not found", id);
		}
		car.setLicenceplate(licenceplate);
		car.setSeatCount(seatCount);
		car.setConvertible(convertible);
		car.setRating(rating);
		car.setEngineType(engineType);
		carRepository.save(car);		
		return car;
	}
	
	
	
	
	
	public Car newCar(String licenceplate, 
			int seatCount, 
			int convertible, 
			int rating, 
			String engineType) {
		Car car = new Car();
		
		car.setLicenceplate(licenceplate);
		car.setSeatCount(seatCount);
		car.setConvertible(convertible);
		car.setRating(rating);
		car.setEngineType(engineType);
		
		carRepository.save(car);
		
		return car;
	}
	
	

}
