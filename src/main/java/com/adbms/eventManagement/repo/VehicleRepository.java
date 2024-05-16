package com.adbms.fleetXpress.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adbms.fleetXpress.entity.StatusCodes;
import com.adbms.fleetXpress.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	@Query(value = "select s from StatusCodes s ")
	List<StatusCodes> getAllStatusCodes();
	
	
	@Query(value = "select v from Vehicle v where v.licensePlate =:licensePlate")
	List<Vehicle> getVehiclesByLicensePlate(String licensePlate);


	@Query(value = "select v from Vehicle v where v.status.statusCode ='AV' ")
	List<Vehicle> getAvailableVehicle();
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE Vehicle SET status.statusCode = :statusCode WHERE vehicleid = :id")
	public void updateVehicleStatus(Long id, String statusCode);
	
	@Query(value = "select v from Vehicle v where v.status.statusCode ='AV' "
			+ "and (v.make like :query or v.model like :query or v.licensePlate like :query ) ")
	List<Vehicle> searchAllVehicles(String query);
	
	@Query(value = "select v from Vehicle v where "
			+ "(v.make like :query or v.model like :query or v.licensePlate like :query ) ")
	List<Vehicle> searchAllAdminVehicles(String query);

}
