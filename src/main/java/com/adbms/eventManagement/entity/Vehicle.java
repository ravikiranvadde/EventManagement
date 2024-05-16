package com.adbms.fleetXpress.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
@Table(name = "vehicle")
public class Vehicle {

	@Id
	@GeneratedValue
	@Column(name = "vehicleid")
	private Long vehicleid;
	
	@Column(name = "make")
	private String make;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "year")
	private Long year;
	
	@Column(name = "licenseplate")
	private String licensePlate;
	
	@OneToOne
	@JoinColumn(name = "statuscode")
	private StatusCodes status;

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

	public StatusCodes getStatus() {
		return status;
	}

	public void setStatus(StatusCodes status) {
		this.status = status;
	}

	
}
