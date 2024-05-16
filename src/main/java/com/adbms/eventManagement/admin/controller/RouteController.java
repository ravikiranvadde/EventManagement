package com.adbms.fleetXpress.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.adbms.fleetXpress.entity.Route;
import com.adbms.fleetXpress.service.RouteService;

@RestController
public class RouteController {

	@Autowired
	private RouteService routeService;
	
	@GetMapping("/admin/routes")
    public ModelAndView getAllCars() {
		ModelAndView modelAndView = new ModelAndView();
		List<Route> routes = routeService.getAllRouteDetails();
        modelAndView.addObject("routeList", routes);
        modelAndView.setViewName("route");
        return modelAndView;
    }
}
