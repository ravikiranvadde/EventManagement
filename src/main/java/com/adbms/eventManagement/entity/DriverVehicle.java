package com.adbms.fleetXpress.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "driver_vehicle")
public class DriverVehicle implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4358736348243270794L;

	@Id
	@OneToOne
	@JoinColumn(name = "driverid")
	public Driver driver;
	
	@Id
	@OneToOne
	@JoinColumn(name = "vehicleid")
	public Vehicle vehicle;

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	

}
