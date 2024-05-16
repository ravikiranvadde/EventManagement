package com.adbms.fleetXpress.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adbms.fleetXpress.entity.RentalHistory;

@Repository
public interface RentalHistoryRepo extends JpaRepository<RentalHistory, Long> {

	@Query("select rh from RentalHistory rh "
			+ "where rh.driver.driverId=:id")
	public List<RentalHistory> getAllRentalDetailsByDriverId(Long id);

}
