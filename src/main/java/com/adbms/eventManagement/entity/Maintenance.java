package com.adbms.fleetXpress.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "maintenance")
public class Maintenance {

	@Id
	@GeneratedValue
	@Column(name = "maintenanceid")
	private Long maintenanceId;
	
	@ManyToOne
	@JoinColumn(name="vehicleid")
	public Vehicle vehicle;
	
	@Column(name = "maintenancetype")
	private String maintenanceType;
	
	@Column(name = "maintenancedate")
	private java.util.Date maintenanceDate;
	
	@Column(name = "cost")
	private Long cost;

	public Long getMaintenanceId() {
		return maintenanceId;
	}

	public void setMaintenanceId(Long maintenanceId) {
		this.maintenanceId = maintenanceId;
	}

	public Vehicle getVehicleId() {
		return vehicle;
	}

	public void setVehicleId(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String getMaintenanceType() {
		return maintenanceType;
	}

	public void setMaintenanceType(String maintenanceType) {
		this.maintenanceType = maintenanceType;
	}

	public java.util.Date getMaintenanceDate() {
		return maintenanceDate;
	}

	public java.util.Date setMaintenanceDate(java.util.Date maintenanceDate) {
		return this.maintenanceDate = maintenanceDate;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}
	
	
}
