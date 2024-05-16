package com.adbms.fleetXpress.dto;

public class VehicleDetails implements VehicleDetailsProjection{
	
	public Long vehicleid;

	public String make;

	public String model;

	public Long year;

	public String licensePlate;

	public String maintenanceDetails;

	public String vehicle_spec;
	
	public Long milesDriven;


	@Override
	public String getMake() {
		// TODO Auto-generated method stub
		return this.make;
	}

	@Override
	public String getModel() {
		// TODO Auto-generated method stub
		return this.model;
	}

	@Override
	public Long getYear() {
		// TODO Auto-generated method stub
		return this.year;
	}

	@Override
	public String getLicensePlate() {
		// TODO Auto-generated method stub
		return this.licensePlate;
	}

	@Override
	public String getMaintenanceDetails() {
		// TODO Auto-generated method stub
		return this.maintenanceDetails;
	}

	@Override
	public String getVehicle_Spec() {
		// TODO Auto-generated method stub
		return this.vehicle_spec;
	}
	
	@Override
	public Long getMilesDriven() {
		// TODO Auto-generated method stub
		return this.milesDriven;
	}

	@Override
	public Long getVehicleid() {
		return this.vehicleid;
	}

	public VehicleDetails(Long vehicleid, String make, String model, Long year, String licensePlate, String maintenanceDetails,
			String vehicle_spec,Long milesDriven) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.licensePlate = licensePlate;
		this.maintenanceDetails = maintenanceDetails;
		this.vehicle_spec = vehicle_spec;
		this.milesDriven = milesDriven;
		this.vehicleid = vehicleid;
	}

}
