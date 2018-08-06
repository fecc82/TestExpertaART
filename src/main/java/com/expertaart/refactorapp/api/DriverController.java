package com.expertaart.refactorapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expertaart.refactorapp.domain.Driver;
import com.expertaart.refactorapp.services.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {

	private final DriverService driverService;


	@Autowired
	public DriverController(DriverService driverService) {
		this.driverService = driverService;
	}

	@GetMapping
	public ResponseEntity<List<Driver>> list() {
		return ResponseEntity.ok(driverService.findAll());
	}
	
}
