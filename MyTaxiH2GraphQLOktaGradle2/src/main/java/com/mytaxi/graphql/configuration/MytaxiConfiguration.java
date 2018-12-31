package com.mytaxi.graphql.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mytaxi.graphql.exception.GraphQLErrorAdapter;
import com.mytaxi.graphql.model.Car;
import com.mytaxi.graphql.repository.CarRepository;
import com.mytaxi.graphql.resolver.Mutation;
import com.mytaxi.graphql.resolver.Query;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;

@Configuration
public class MytaxiConfiguration {
	
	
	@Bean
	public GraphQLErrorHandler errorHandler() {
		return new GraphQLErrorHandler() {
			
			@Override
			public List<GraphQLError> processErrors(List<GraphQLError> errors) {
				List<GraphQLError> clientErrors = errors.stream()
						.filter(this::isClientError)
						.collect(Collectors.toList());

				List<GraphQLError> serverErrors = errors.stream()
						.filter(e -> !isClientError(e))
						.map(GraphQLErrorAdapter::new)
						.collect(Collectors.toList());

				List<GraphQLError> e = new ArrayList<>();
				e.addAll(clientErrors);
				e.addAll(serverErrors);
				return e;
			}
			
			protected boolean isClientError(GraphQLError error) {
				return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
			}
		};
			
	}
	
	@Bean
	public Query query(CarRepository carRepository) {
		return new Query(carRepository);
	}
	
	@Bean
	public Mutation mutation(CarRepository carRepository) {
		return new Mutation(carRepository);
	}
	
	@Bean
	public CommandLineRunner demo(CarRepository carRepository) {
		return (args) -> {
			carRepository.save(new Car("124-FINNISH-33",4,0,29,"GASOLINE"));
		};
	}
	
	
	
}
