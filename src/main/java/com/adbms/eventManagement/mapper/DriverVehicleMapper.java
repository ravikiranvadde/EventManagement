package com.adbms.fleetXpress.mapper;

import org.springframework.stereotype.Component;

import com.adbms.fleetXpress.dto.DriverVehicleDto;
import com.adbms.fleetXpress.entity.DriverVehicle;

@Component
public class DriverVehicleMapper{
	
	public DriverVehicleDto toDto(DriverVehicle ent) {
		DriverVehicleDto dto = new DriverVehicleDto();
		dto.setDriverId(ent.getDriver().getDriverId());
		dto.setFullName(ent.getDriver().getFirstName() + " " + ent.getDriver().getLastName());
		dto.setPhone(ent.getDriver().getPhone());
		dto.setLicenseNumber(ent.getDriver().getLicenseNumber());
		dto.setVehicleid(ent.getVehicle().getVehicleid());
		dto.setLicensePlate(ent.getVehicle().getLicensePlate());
		dto.setMake(ent.getVehicle().getMake());
		dto.setModel(ent.getVehicle().getModel());
		dto.setYear(ent.getVehicle().getYear());
		dto.setStatus(ent.getVehicle().getStatus().getStatus());
		return dto;
	}

}
