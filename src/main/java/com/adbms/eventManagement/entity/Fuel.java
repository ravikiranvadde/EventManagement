package com.adbms.fleetXpress.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fuel")
public class Fuel {
	
	@Id
	@GeneratedValue
	@Column(name = "recordid")
	private Long recordId;
	
	@OneToOne
	@JoinColumn(name = "vehicleid")
	public Vehicle vehicle;
	
	@OneToOne
	@JoinColumn(name = "driverid")
	public Driver driver;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "gallonsfilled")
	private Long gallonsFilled;
	
	@Column(name = "milesdriven")
	private Long milesDriven;

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getGallonsFilled() {
		return gallonsFilled;
	}

	public void setGallonsFilled(Long gallonsFilled) {
		this.gallonsFilled = gallonsFilled;
	}

	public Long getMilesDriven() {
		return milesDriven;
	}

	public void setMilesDriven(Long milesDriven) {
		this.milesDriven = milesDriven;
	}
	
	

}
