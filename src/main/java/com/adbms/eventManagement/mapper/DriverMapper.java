package com.adbms.fleetXpress.mapper;

import org.springframework.stereotype.Component;

import com.adbms.fleetXpress.dto.DriverDTO;
import com.adbms.fleetXpress.entity.Driver;

@Component
public class DriverMapper {
	
	public DriverDTO toDriverDto(Driver driver) {
		DriverDTO driverDTO = new DriverDTO();
		driverDTO.setDriverId(driver.getDriverId());
		driverDTO.setFirstName(driver.getFirstName()!=null?driver.getFirstName():"");
		driverDTO.setLastName(driver.getLastName()!=null?driver.getLastName():"");
		driverDTO.setLicenseNumber(driver.getLicenseNumber()!=null?driver.getLicenseNumber():"");
		String phone = driver.getPhone()!=null?driver.getPhone().replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3"):"";
		driverDTO.setPhone(phone);
		return driverDTO;
	}
	
	public Driver fromDriverDTO(DriverDTO dto) {
		Driver d = new Driver();
		d.setFirstName(dto.getFirstName());
		d.setLastName(dto.getLastName());
		d.setLicenseNumber(dto.getLicenseNumber());
		d.setPhone(dto.getPhone());
		return d;
	}

}
