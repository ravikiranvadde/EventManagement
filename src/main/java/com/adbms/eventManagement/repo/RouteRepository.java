package com.adbms.fleetXpress.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adbms.fleetXpress.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

}
