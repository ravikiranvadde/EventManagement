package com.adbms.fleetXpress.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adbms.fleetXpress.entity.Fuel;

@Repository
public interface FuelRepository extends JpaRepository<Fuel, Long> {

}
