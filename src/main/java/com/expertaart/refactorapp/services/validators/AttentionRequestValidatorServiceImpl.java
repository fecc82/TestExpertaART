package com.expertaart.refactorapp.services.validators;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expertaart.refactorapp.domain.Attention;
import com.expertaart.refactorapp.domain.AttentionStatus;
import com.expertaart.refactorapp.domain.Driver;
import com.expertaart.refactorapp.services.AttentionService;
import com.expertaart.refactorapp.services.DriverService;
import com.expertaart.refactorapp.services.validators.exceptions.AttentionRequestValidatorsException;

@Service
public class AttentionRequestValidatorServiceImpl implements AttentionRequestValidatorService {
	
	@Autowired
	private AttentionService attentionService;
	
	@Autowired
	private DriverService driverService;
	
	@Override
	public Attention validatePostConfirm(Long attentionId, Long driverId) throws AttentionRequestValidatorsException {
		if(attentionId == null) {
			throw new AttentionRequestValidatorsException(AttentionErrorCode.INVALID_REQUEST); 
		}
		
		Optional<Attention> attention = attentionService.find(attentionId);
		if(!attention.isPresent()) {
			throw new AttentionRequestValidatorsException(AttentionErrorCode.NOT_FOUND); 
		}
		
		Optional<Driver> driver= driverService.find(driverId);
		if(!driver.isPresent()) {
			throw new AttentionRequestValidatorsException(AttentionErrorCode.DRIVER_NOT_FOUND); 
		}
		
		if(attention.get().getStatus() == AttentionStatus.CANCELLED) {
			throw new AttentionRequestValidatorsException(AttentionErrorCode.CANCELLED); 
		}
		
		if(attention.get().getUser() == null) {
			throw new AttentionRequestValidatorsException(AttentionErrorCode.NOT_USER_UUID); 
		}
		
		if(attention.get().getDriver() != null || attention.get().getStatus() != AttentionStatus.REQUESTED) {
			throw new AttentionRequestValidatorsException(AttentionErrorCode.INVALID_REQUEST); 
		}
		
		return attention.get();
	}

}
