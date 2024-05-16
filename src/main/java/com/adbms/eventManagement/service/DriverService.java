package com.adbms.fleetXpress.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.adbms.fleetXpress.dto.DriverDTO;
import com.adbms.fleetXpress.dto.DriverVehicleDto;
import com.adbms.fleetXpress.entity.Driver;
import com.adbms.fleetXpress.entity.DriverVehicle;
import com.adbms.fleetXpress.entity.StatusCodes;
import com.adbms.fleetXpress.mapper.DriverMapper;
import com.adbms.fleetXpress.mapper.DriverVehicleMapper;
import com.adbms.fleetXpress.repo.DriverRepository;
import com.adbms.fleetXpress.repo.DriverVehicleRepository;

@Service
public class DriverService {
	
	
	@Autowired
	public DriverRepository driverRepo;
	
	@Autowired
	public DriverVehicleMapper mapper;
	
	@Autowired
	public DriverMapper driverMapper;
	
	public List<Driver> getAllDrivers(){
		return driverRepo.findAll();
	}

	public List<Driver> searchDrivers(String query){
		query = "%"+query+"%";
		return driverRepo.searchDrivers(query);
	}

	
	public List<DriverVehicleDto> getAllDriversAssignedWithVehicles(){
		List<DriverVehicle> data = driverRepo.findAllDriverVehicles();
		List<DriverVehicleDto> list = new ArrayList<>();
		for(DriverVehicle driver : data) {
			DriverVehicleDto dvDto = new DriverVehicleDto();
			dvDto = mapper.toDto(driver);
			list.add(dvDto);
		}
		return list;
		
	}
	
	public StatusCodes getStatusCode(String status) {
		return driverRepo.getStatusCodeBycode(status);
	}
	
	public String saveDriver(DriverDTO driver) {
		Driver driv = driverRepo.getDriverByLicense(driver.getLicenseNumber());
		try {
			if (driv==null) {
				Driver drivEntity = driverMapper.fromDriverDTO(driver);
				driverRepo.save(drivEntity);
				return "Saved Successfully";
			}
		} catch (Exception e) {

			return "Error While Saving";
		}
		return "Error While Saving";
	}
	
	public Driver getDriverDetailsByLicense(String licenseNumber) {
		return driverRepo.getDriverByLicense(licenseNumber);
		
	}
	
	public String updateDriverDetails(DriverDTO dto) {
		String message;
		try {
			String phone = dto.getPhone();
			Long id = dto.getDriverId();
		 driverRepo.updateDriver(phone,id);
		 message ="Updated Successfully";
		} catch (Exception e) {
			// TODO: handle exception
			 message = "Error While updating";
		}
		return message;
	}
	
}
