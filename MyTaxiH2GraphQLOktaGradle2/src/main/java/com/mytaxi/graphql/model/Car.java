package com.mytaxi.graphql.model;

import javax.persistence.*;

/*
 license_plate, seat_count, convertible, rating, engine_type (electric, gas, ...)
 */

@Entity
public class Car {
	@Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@Column(name="licenceplate", nullable=false)
	private String licenceplate;
	
	@Column(name="seatcount")
	private int seatCount;
	
	@Column(name="convertible") //0->No convertible; 1->Convertible
	private int convertible;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="enginetype")
	private String engineType;
	
	public Car() {
		
	}
	
	public Car(String licenceplate, int seatCount, int convertible, int rating, String engineType) {
		super();
		this.licenceplate = licenceplate;
		this.seatCount = seatCount;
		this.convertible = convertible;
		this.rating = rating;
		this.engineType = engineType;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLicenceplate() {
		return licenceplate;
	}

	public void setLicenceplate(String licenceplate) {
		this.licenceplate = licenceplate;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public int getConvertible() {
		return convertible;
	}

	public void setConvertible(int convertible) {
		this.convertible = convertible;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Car book = (Car) o;
	    return id.equals(book.id);
	}

    @Override
	public int hashCode() {
	    return id.hashCode();
	}

	@Override
	public String toString() {
	       return "Car{id=" + id + ",seatcount ='" + this.seatCount + ",rating ='" + this.rating + ",licenceplate=" + this.licenceplate +
	                ",convertibletype=" + this.convertible + ",enginetype=" + this.engineType +'}';
	}


	
	
	
	
}
