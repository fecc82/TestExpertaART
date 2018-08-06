package com.expertaart.refactorapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expertaart.refactorapp.domain.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{

	
}
