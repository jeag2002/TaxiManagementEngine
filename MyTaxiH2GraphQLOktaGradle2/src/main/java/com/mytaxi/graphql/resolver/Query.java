package com.mytaxi.graphql.resolver;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.mytaxi.graphql.model.Car;
import com.mytaxi.graphql.repository.CarRepository;

public class Query implements GraphQLQueryResolver{
	
	private CarRepository carRepository;
	
	public Query(CarRepository _carRepository) {
		this.carRepository = _carRepository;
	}
	
	public Iterable<Car> findAllCars(){
		return carRepository.findAll();
	}
	
	public long countCars() {
		return carRepository.count();
	}
	

}
