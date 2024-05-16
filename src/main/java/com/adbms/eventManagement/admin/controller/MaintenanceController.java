package com.adbms.fleetXpress.admin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.adbms.fleetXpress.entity.Maintenance;
import com.adbms.fleetXpress.service.MaintenanceService;

@RestController
public class MaintenanceController {
	@Autowired
	private MaintenanceService maintenanceService;
	
	@Autowired
	VehicleController vehicleController;
	
	@GetMapping("/admin/maintenance")
    public ModelAndView getAllCars() {
		ModelAndView modelAndView = new ModelAndView();
		List<Maintenance> maintenances = maintenanceService.getAllMaintenanceDetails();
        modelAndView.addObject("maintenanceList", maintenances);
        modelAndView.setViewName("maintenance");
        return modelAndView;
    }
	
	@PostMapping("/admin/saveMaintenance")
	public ModelAndView addMaintenanceRecord(Long vehicleid, String maintenanceType, String maintenanceDate, Long cost) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date date = formatter.parse(maintenanceDate);
		maintenanceService.addMaintenance(vehicleid, maintenanceType, date, cost);
		return vehicleController.getVehicleDetails(vehicleid);
	}
	
	@GetMapping("/admin/addMaintenance/{vehicleid}")
	public ModelAndView addMaintenance(@PathVariable(name = "vehicleid") Long vehicleid) throws ParseException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("vehicleid",vehicleid);
		modelAndView.setViewName("addMaintenance");
		return modelAndView;
	}
}
