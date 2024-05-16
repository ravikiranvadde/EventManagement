package com.adbms.fleetXpress.dto;

public class VehicleDto {
	
	
	public Long vehicleid;
	
	public String make;
	
	public String model;
	
	public Long year;
	
	public String licensePlate;
	
	public String status;
	
	public Long getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(Long vehicleid) {
		this.vehicleid = vehicleid;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public VehicleDto() {
		
	}

	public VehicleDto(String make, String model, Long year, String licensePlate, String status) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.licensePlate = licensePlate;
		this.status = status;
	}
	
	

}
