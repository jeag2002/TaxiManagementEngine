package com.mytaxi.graphql.repository;

import org.springframework.data.repository.CrudRepository;

import com.mytaxi.graphql.model.Car;

public interface CarRepository extends CrudRepository<Car, Long>{
}
