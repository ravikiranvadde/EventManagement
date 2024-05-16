package com.adbms.fleetXpress.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rent_history")
public class RentalHistory {
	
	@Id
	@GeneratedValue
	@Column(name = "hist_id")
	private Long histId;
	
	@OneToOne
	@JoinColumn(name = "vehicleid")
	private Vehicle vehicle;
	
	@OneToOne
	@JoinColumn(name = "driverid")
	private Driver driver;
	
	@Column(name = "from_date")
	private Date fromDate;
	
	@Column(name = "to_date")
	private Date toDate;

	public Long getHistId() {
		return histId;
	}

	public void setHistId(Long histId) {
		this.histId = histId;
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
	
	

}
