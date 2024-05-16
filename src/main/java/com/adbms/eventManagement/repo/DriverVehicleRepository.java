package com.adbms.fleetXpress.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adbms.fleetXpress.entity.DriverVehicle;

@Repository
public interface DriverVehicleRepository {

	@Query(value = "select * from DriverVehicle ")
	public List<DriverVehicle> findAll();
	
}
