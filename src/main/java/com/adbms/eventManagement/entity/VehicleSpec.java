package com.adbms.fleetXpress.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_spec")
public class VehicleSpec {

	@Id
	@GeneratedValue
	@Column(name = "spec_id")
	private Long specId;

	@Column(name = "vehicleid")
	private String vehicleid;

	@Column(name = "vehicle_spec")
	private String VehicleSpec;

	public Long getSpecId() {
		return specId;
	}

	public void setSpecId(Long specId) {
		this.specId = specId;
	}

	public String getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(String vehicleid) {
		this.vehicleid = vehicleid;
	}

	public String getVehicleSpec() {
		return VehicleSpec;
	}

	public void setVehicleSpec(String vehicleSpec) {
		VehicleSpec = vehicleSpec;
	}

	public VehicleSpec(Long specId, String vehicleid, String vehicleSpec) {
		super();
		this.specId = specId;
		this.vehicleid = vehicleid;
		VehicleSpec = vehicleSpec;
	}

	public VehicleSpec() {

	}
}
