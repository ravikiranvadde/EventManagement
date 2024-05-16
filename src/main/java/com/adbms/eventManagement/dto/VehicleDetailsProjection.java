package com.adbms.fleetXpress.dto;

public interface VehicleDetailsProjection {
	
	String getMake();
	
	String getModel();
	
	Long getYear();
	
	String getLicensePlate();
	
	String getMaintenanceDetails();
	
	String getVehicle_Spec();
	
	Long getMilesDriven();

	Long getVehicleid();

}
