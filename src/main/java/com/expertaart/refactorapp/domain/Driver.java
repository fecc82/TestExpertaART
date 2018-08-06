package com.expertaart.refactorapp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="driver")
public class Driver {

	@Id
	private Long id;

	@Column
	private String name;
	
	@Enumerated(EnumType.STRING)
	private DriverStatus status;

	@JoinColumn(name = "car_id", unique = true)
    @OneToOne(cascade = CascadeType.ALL)
	private Car car;
	
	public Driver() {
	}

	public Driver(Long id, String name, DriverStatus status, Car car) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.car = car;
	}

	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public DriverStatus getStatus() {
		return status;
	}

	public Car getCar() {
		return car;
	}

	public void setDriverStatus(DriverStatus status) {
		this.status = status;
	}

}
