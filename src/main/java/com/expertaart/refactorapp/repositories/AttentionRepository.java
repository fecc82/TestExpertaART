package com.expertaart.refactorapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expertaart.refactorapp.domain.Attention;

@Repository
public interface AttentionRepository extends JpaRepository<Attention, Long>{
	
}
