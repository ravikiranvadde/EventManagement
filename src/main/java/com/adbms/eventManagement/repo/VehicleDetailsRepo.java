package com.adbms.fleetXpress.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adbms.fleetXpress.dto.VehicleDetails;
import com.adbms.fleetXpress.dto.VehicleDetailsProjection;
import com.adbms.fleetXpress.entity.VehicleSpec;

@Repository
public interface VehicleDetailsRepo extends JpaRepository<VehicleSpec, Long> {

	
	@Query(value = "select v.vehicleid, v.make as make,v.model as model,v.\"year\" as year ,v.licenseplate as licensePlate, STRING_AGG(CONCAT(m.maintenanceType, ': ', m.maintenanceDate), ', ') AS maintenanceDetails, vs.vehicle_spec as vehicle_spec,SUM(f.milesDriven) as milesDriven "
			+ "FROM vehicle v "
			+ "LEFT JOIN maintenance m ON m.vehicleid = v.vehicleid "
			+ "LEFT JOIN vehicle_specs vs ON vs.vehicleid = v.vehicleid "
			+ "LEFT JOIN Fuel f on f.vehicleid = v.vehicleid "
			+ "WHERE v.vehicleid = :id GROUP by v.vehicleid,vs.spec_id"
			,nativeQuery = true)
	VehicleDetailsProjection getVehicleDetails(Long id);

}
