package com.adbms.fleetXpress.dto;

import java.util.Date;

public class RentalDetails {

	public String make;

	public String model;

	public Long year;

	public String licensePlate;

	public Date fromDate;

	public Date toDate;

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

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public RentalDetails(String make, String model, Long year, String licensePlate, Date fromDate, Date toDate) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.licensePlate = licensePlate;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public RentalDetails() {
	}
	
	

}
