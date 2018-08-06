package com.expertaart.refactorapp.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.expertaart.refactorapp.services.dto.DeviceType;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(columnDefinition = "uuid")
	private String uuid;
	
	@Column
	private String name;

	@Enumerated(EnumType.STRING)
	private DeviceType deviceType;
	
	public User() {
	}

	public User(String name, DeviceType deviceType) {
		this.uuid = UUID.randomUUID().toString();
		this.name = name;
		this.deviceType = deviceType;
	}

	public String getUuid() {
		return uuid;
	}
	
	public String getName() {
		return name;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

}
