package com.adbms.fleetXpress.admin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.adbms.fleetXpress.dto.VehicleDetails;
import com.adbms.fleetXpress.dto.VehicleDto;
import com.adbms.fleetXpress.entity.Driver;
import com.adbms.fleetXpress.entity.RentalHistory;
import com.adbms.fleetXpress.entity.StatusCodes;
import com.adbms.fleetXpress.entity.Vehicle;
import com.adbms.fleetXpress.repo.RentalHistoryRepo;
import com.adbms.fleetXpress.service.DriverService;
import com.adbms.fleetXpress.service.MyUserDetails;
import com.adbms.fleetXpress.service.UserDetailService;
import com.adbms.fleetXpress.service.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehService;

	@Autowired
	UserDetailService userService;

	@Autowired
	DriverService driverService;

	@Autowired
	RentalHistoryRepo rentalHistRepo;

	@GetMapping("/admin/vehicles")
	public ModelAndView getAllCars() {
		String banner = null;
		ModelAndView modelAndView = new ModelAndView();
		List<StatusCodes> status = vehService.getAllStatusCodes();
		List<Vehicle> veh = vehService.getAllVehicles();
		modelAndView.addObject("vehicles", veh);
		modelAndView.addObject("status", status);
		modelAndView.addObject("banner", banner);
		modelAndView.setViewName("vehicle");
		return modelAndView;
	}

	@GetMapping("/admin/searchVehicles")
	public List<Vehicle> searchAllVehicles(@RequestParam String query) {
		List<Vehicle> veh = vehService.searchAllAdminVehicles(query);
		return veh;
	}

	@GetMapping("/searchVehicles")
	public List<Vehicle> searchAllCars(@RequestParam String query) {
		List<Vehicle> veh = vehService.searchAllVehicles(query);
		return veh;
	}

	@PostMapping("/admin/saveVehicle")
	public ModelAndView saveVehicle(VehicleDto vehicle) {
		String banner = " ";
		try {
			vehService.saveVehicle(vehicle);
			banner = "Saved Successfully";
		} catch (Exception e) {
			banner = "Error";
		}
		ModelAndView modelAndView = new ModelAndView();
		List<StatusCodes> status = vehService.getAllStatusCodes();
		List<Vehicle> veh = vehService.getAllVehicles();
		modelAndView.addObject("vehicles", veh);
		modelAndView.addObject("status", status);
		modelAndView.addObject("banner", banner);
		modelAndView.setViewName("vehicle");
		return modelAndView;

	}

	@GetMapping("/admin/editVehicle/{vehicleid}")
	public ModelAndView getCarByID(@PathVariable(name = "vehicleid") Long vehicleid) {
		ModelAndView modelAndView = new ModelAndView();
		List<StatusCodes> status = vehService.getAllStatusCodes();
		Vehicle veh = vehService.getVehicleByID(vehicleid);
		modelAndView.addObject("vehicle", veh);
		modelAndView.addObject("status", status);
		modelAndView.setViewName("editVehicle");
		return modelAndView;
	}

	@PostMapping("/admin/updateVehicle")
	public ModelAndView editVehicle(VehicleDto vehicle) {
		String banner = "";
		try {
			vehService.editVehicle(vehicle);
			banner = "Updated Successfully";
		} catch (Exception e) {
			banner = "Error";
		}
		return getAllCars();
	}

	@PostMapping("/rentVehicle")
	public void rentVehicle(String fromDate, String toDate, String vehicleId) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date todate = formatter.parse(toDate);
		Date fromdate = formatter.parse(fromDate);
		Long vehicleid = Long.parseLong(vehicleId);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MyUserDetails users = (MyUserDetails) userService.loadUserByUsername(auth.getName());
		Driver driver = driverService.getDriverDetailsByLicense(users.getUser().getLicenseNumber());
		vehService.updateVehicleStatusById(vehicleid, "REN");
		Vehicle vehicle = vehService.getVehicleByID(vehicleid);
		RentalHistory rh = new RentalHistory();
		rh.setDriver(driver);
		rh.setFromDate(fromdate);
		rh.setToDate(todate);
		rh.setVehicle(vehicle);
		rentalHistRepo.save(rh);
	}

	@GetMapping("/vehicleDetails/{vehicleid}")
	public ModelAndView getVehicleDetails(@PathVariable(name = "vehicleid") Long vehicleid) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MyUserDetails users = (MyUserDetails) userService.loadUserByUsername(auth.getName());
		Boolean isAdmin = false;
		if (users.getUser().getRoles().getRolename().equals("ADMIN")) {
			isAdmin = true;
		}
		VehicleDetails veh = vehService.getVehicleDetails(vehicleid);
		modelAndView.addObject("vehicleDetails", veh);
		modelAndView.addObject("isAdmin", isAdmin);
		modelAndView.setViewName("vehicleDetails");
		return modelAndView;
	}
}
