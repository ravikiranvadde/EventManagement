package com.adbms.fleetXpress.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adbms.fleetXpress.dto.VehicleDto;
import com.adbms.fleetXpress.entity.StatusCodes;
import com.adbms.fleetXpress.entity.Vehicle;
import com.adbms.fleetXpress.mapper.VehicleMapper;
import com.adbms.fleetXpress.repo.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	public VehicleRepository vehicleRepo;
	
	@Autowired
	public VehicleMapper vehMapper;
	
	public List<Vehicle> getAllVehicles(){
		return vehicleRepo.findAll();
	}
	
	public List<StatusCodes> getAllStatusCodes(){
		return vehicleRepo.getAllStatusCodes();
	}

	public Vehicle saveVehicle(VehicleDto vehicledto) {
		List<Vehicle> list =vehicleRepo.getVehiclesByLicensePlate(vehicledto.getLicensePlate());
		if(!list.isEmpty()) {
		Vehicle vehicle = vehMapper.toVehicle(vehicledto);
		return vehicleRepo.save(vehicle);
		}
		return null;
	}
	
	public Vehicle editVehicle(VehicleDto vehicle) {
		Vehicle veh =vehicleRepo.getById(vehicle.getVehicleid());
		if(veh!=null) {
		veh = vehMapper.toVehicle(vehicle);
		return vehicleRepo.save(veh);
		}
		return null;
	}

	public Vehicle getVehicleByID(Long id) {
		return vehicleRepo.getById(id);
	}

	public List<Vehicle> getAvailableVehicle() {
		return vehicleRepo.getAvailableVehicle();
	}
	
	public void updateVehicleStatusById(Long id, String statusCode) {
		vehicleRepo.updateVehicleStatus(id,statusCode);
	}
}
