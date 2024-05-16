package com.adbms.fleetXpress.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.adbms.fleetXpress.entity.Fuel;
import com.adbms.fleetXpress.service.FuelService;

@RestController
public class FuelController {

	@Autowired
	private FuelService fuelService;
	
	@GetMapping("/admin/fuel")
    public ModelAndView getAllCars() {
		ModelAndView modelAndView = new ModelAndView();
		List<Fuel> fuel = fuelService.getAllFuelDetails();
        modelAndView.addObject("fuelList", fuel);
        modelAndView.setViewName("fuel");
        return modelAndView;
    }
}
