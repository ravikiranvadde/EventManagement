package com.adbms.fleetXpress.mapper;

import org.springframework.stereotype.Component;

import com.adbms.fleetXpress.dto.RentalDetails;
import com.adbms.fleetXpress.entity.RentalHistory;

@Component
public class RentalDetailsMapper {
	
	public RentalDetails toDto(RentalHistory rh) {
		RentalDetails rd = new RentalDetails();
		rd.setMake(rh.getVehicle().getMake());
		rd.setModel(rh.getVehicle().getModel());
		rd.setYear(rh.getVehicle().getYear());
		rd.setLicensePlate(rh.getVehicle().getLicensePlate());
		rd.setFromDate(rh.getFromDate());
		rd.setToDate(rh.getToDate());
		return rd;
	}

}
