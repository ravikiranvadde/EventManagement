package com.adbms.fleetXpress.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adbms.fleetXpress.dto.VehicleDto;
import com.adbms.fleetXpress.entity.Vehicle;
import com.adbms.fleetXpress.service.DriverService;

@Component
public class VehicleMapper {
	
	@Autowired
	DriverService drivService;

	public Vehicle toVehicle(VehicleDto dto) {
		Vehicle veh = new Vehicle();
		if(dto.getVehicleid()!=null) {
			veh.setVehicleid(dto.getVehicleid());
		}
		veh.setMake(dto.getMake());
		veh.setModel(dto.getModel());
		veh.setYear(dto.getYear());
		veh.setLicensePlate(dto.getLicensePlate());
		veh.setStatus(drivService.getStatusCode(dto.getStatus()));
		return veh;
	}
	
	public VehicleDto fromVehicle(Vehicle d) {
		VehicleDto veh = new VehicleDto();
		if(d.getVehicleid()!=null) {
			veh.setVehicleid(d.getVehicleid());
		}
		veh.setMake(d.getMake()!=null?d.getMake():"");
		veh.setModel(d.getModel()!=null?d.getModel():"");
		veh.setYear(d.getYear());
		veh.setLicensePlate(d.getLicensePlate()!=null?d.getLicensePlate():"");
		veh.setStatus(d.getStatus()!=null?d.getStatus().getStatusCode():"");
		return veh;
	}
}
