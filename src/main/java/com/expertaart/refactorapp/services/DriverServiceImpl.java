package com.expertaart.refactorapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expertaart.refactorapp.domain.Driver;
import com.expertaart.refactorapp.repositories.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService {

	private final DriverRepository driverRepository;

	@Autowired
	public DriverServiceImpl(DriverRepository driverRepository) {
		this.driverRepository = driverRepository;
	}
	
	@Override
	public Optional<Driver> find(Long id) {
		return driverRepository.findById(id);
	}
	
	@Override
	public List<Driver> findAll(){
		return driverRepository.findAll();
	}
	
}
