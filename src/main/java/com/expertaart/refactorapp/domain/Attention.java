package com.expertaart.refactorapp.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="attention")
public class Attention {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name = "driver_id")
	@OneToOne
	private Driver driver;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private AttentionStatus status;
	
	@JoinColumn(name = "uuid")
	@OneToOne
	private User user;
	
		
	public Attention() {
	}

	public Attention(Long id, Driver driver, AttentionStatus status, User user) {
		this.id = id;
		this.driver = driver;
		this.status = status;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public Driver getDriver() {
		return driver;
	}

	public AttentionStatus getStatus() {
		return status;
	}


	public User getUser() {
		return user;
	}
	
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	public void setStatus(AttentionStatus status) {
		this.status = status;
	}
	
}
