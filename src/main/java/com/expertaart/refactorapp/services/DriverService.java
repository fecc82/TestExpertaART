package com.expertaart.refactorapp.services;

import java.util.List;
import java.util.Optional;

import com.expertaart.refactorapp.domain.Driver;

public interface DriverService {
	
	Optional<Driver>  find(Long id);
	
	List<Driver> findAll();
}
