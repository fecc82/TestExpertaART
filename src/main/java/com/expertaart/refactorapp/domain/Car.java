package com.expertaart.refactorapp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="car")
public class Car {

	@Id
	private Long id;
	
	
	public Car() {
	}

	public Car(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
}
