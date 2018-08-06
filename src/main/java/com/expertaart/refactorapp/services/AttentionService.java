package com.expertaart.refactorapp.services;

import java.util.List;
import java.util.Optional;

import com.expertaart.refactorapp.domain.Attention;

public interface AttentionService {

	Optional<Attention> find(Long id);

	List<Attention> findAll();
	
	void processAttentionConfirmation(Attention attention, Long driverId);
		
}