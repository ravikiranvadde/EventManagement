package com.adbms.fleetXpress.dto;

public class DriverDTO {
	
	
	public Long driverId;
	
	
	public String firstName;
	
	
	public String lastName;
	
	
	public String licenseNumber;
	
	
	public String phone;


	public Long getDriverId() {
		return driverId;
	}


	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getLicenseNumber() {
		return licenseNumber;
	}


	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public DriverDTO(Long driverId, String firstName, String lastName, String licenseNumber, String phone) {
		super();
		this.driverId = driverId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.licenseNumber = licenseNumber;
		this.phone = phone;
	}
	
	public DriverDTO() {}

	
}
