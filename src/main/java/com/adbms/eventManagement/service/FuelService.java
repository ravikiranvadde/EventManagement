package com.adbms.fleetXpress.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adbms.fleetXpress.entity.Fuel;
import com.adbms.fleetXpress.repo.FuelRepository;

@Service
public class FuelService {
	
	@Autowired
	public FuelRepository fuelRepo;
	
	public List<Fuel> getAllFuelDetails(){
		return fuelRepo.findAll();
	}

}
