package com.adbms.fleetXpress.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adbms.fleetXpress.entity.Route;
import com.adbms.fleetXpress.repo.RouteRepository;

@Service	
public class RouteService {

	@Autowired
	public RouteRepository routeRepo;
	
	public List<Route> getAllRouteDetails(){
		return routeRepo.findAll();
	}
}
