package com.adbms.fleetXpress.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adbms.fleetXpress.entity.Maintenance;
import com.adbms.fleetXpress.entity.Vehicle;
import com.adbms.fleetXpress.repo.MaintenanceRepository;

@Service
public class MaintenanceService {
	
	@Autowired
	public MaintenanceRepository maintenanceRepo;
	
	@Autowired
	public VehicleService vehicleService;
	
	public List<Maintenance> getAllMaintenanceDetails(){
		return maintenanceRepo.findAll();
	}
	
	public void addMaintenance(Long vehicleid, String maintenanceType, Date maintenanceDate, Long cost){
		Vehicle v = vehicleService.getVehicleByID(vehicleid);
		Maintenance m = new Maintenance();
		m.setCost(cost);
		m.setMaintenanceDate(maintenanceDate);
		m.setMaintenanceType(maintenanceType);
		m.setVehicleId(v);
		maintenanceRepo.save(m);
		
	}

}
