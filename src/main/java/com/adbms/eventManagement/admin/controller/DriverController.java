package com.adbms.fleetXpress.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.adbms.fleetXpress.dto.DriverDTO;
import com.adbms.fleetXpress.dto.DriverVehicleDto;
import com.adbms.fleetXpress.entity.Driver;
import com.adbms.fleetXpress.mapper.DriverMapper;
import com.adbms.fleetXpress.service.DriverService;

@RestController
public class DriverController {

	@Autowired
	private DriverService driverService;
	
	@Autowired
	DriverMapper driverMapper;
	
	@GetMapping("/admin/drivers")
    public ModelAndView getAllCars() {
		ModelAndView modelAndView = new ModelAndView();
		List<Driver> driver = driverService.getAllDrivers();
		List<DriverDTO> dtos = new ArrayList<>();
		for(Driver d: driver) {
			DriverDTO dto =driverMapper.toDriverDto(d);
			dtos.add(dto);
		}
        modelAndView.addObject("drivers", dtos);
        modelAndView.setViewName("driver");
        return modelAndView;
    }
	
	@GetMapping("/admin/driverVehicles")
    public ModelAndView getAllDriverAssigned() {
		ModelAndView modelAndView = new ModelAndView();
		List<DriverVehicleDto> driverVehs = driverService.getAllDriversAssignedWithVehicles();
        modelAndView.addObject("list", driverVehs);
        modelAndView.setViewName("driverVehicle");
        return modelAndView;
    }
	
	@GetMapping("/admin/searchDrivers")
    public List<Driver> searchDrivers(@RequestParam(value="query") String query) {
		List<Driver> drivers = driverService.searchDrivers(query);
        return drivers;
    }
	
	@PostMapping("/admin/saveDriver")
	public ModelAndView saveDriver(DriverDTO dto) {
		String banner = null;
		try {
		banner = driverService.saveDriver(dto);
		} catch (Exception e) {
			banner = "Error while Saving";
		}
		ModelAndView modelAndView = new ModelAndView();
		List<Driver> driver = driverService.getAllDrivers();
        modelAndView.addObject("drivers", driver);
        modelAndView.addObject("banner",banner);
        modelAndView.setViewName("driver");
        return modelAndView;
	}
}
