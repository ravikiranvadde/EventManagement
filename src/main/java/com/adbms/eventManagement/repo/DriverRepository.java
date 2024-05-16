package com.adbms.fleetXpress.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adbms.fleetXpress.entity.Driver;
import com.adbms.fleetXpress.entity.DriverVehicle;
import com.adbms.fleetXpress.entity.StatusCodes;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

	@Query(value = "select dv from DriverVehicle dv ")
	List<DriverVehicle> findAllDriverVehicles();

	@Query(value = "select s from StatusCodes s where s.statusCode = :code")
	public StatusCodes getStatusCodeBycode(String code);

	@Query(value = "select d from Driver d where d.licenseNumber = :license")
	public Driver getDriverByLicense(String license);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Driver SET phone = :phone WHERE driverId = :id")
	public void updateDriver(String phone, Long id);
	
	@Query(value = "select d from Driver d where (d.firstName like :query or d.lastName like :query) ")
	List<Driver> searchDrivers(String query);
}
