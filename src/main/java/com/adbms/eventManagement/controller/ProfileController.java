package com.adbms.fleetXpress.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.adbms.fleetXpress.dto.DriverDTO;
import com.adbms.fleetXpress.dto.RentalDetails;
import com.adbms.fleetXpress.entity.Driver;
import com.adbms.fleetXpress.entity.RentalHistory;
import com.adbms.fleetXpress.mapper.DriverMapper;
import com.adbms.fleetXpress.mapper.RentalDetailsMapper;
import com.adbms.fleetXpress.mapper.VehicleMapper;
import com.adbms.fleetXpress.repo.RentalHistoryRepo;
import com.adbms.fleetXpress.service.DriverService;
import com.adbms.fleetXpress.service.MyUserDetails;
import com.adbms.fleetXpress.service.UserDetailService;
import com.adbms.fleetXpress.service.VehicleService;

@RestController
public class ProfileController {

	@Autowired
	UserDetailService userService;

	@Autowired
	DriverService driverService;

	@Autowired
	VehicleService vehService;

	@Autowired
	DriverMapper driverMapper;

	@Autowired
	VehicleMapper vehicleMapper;
	
	@Autowired
	RentalHistoryRepo rentalHistoryRepo;
	
	@Autowired
	RentalDetailsMapper rentalDetailsMapper;

	@GetMapping("/profile")
	public ModelAndView getDriverProfile() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MyUserDetails users = (MyUserDetails) userService.loadUserByUsername(auth.getName());
		String role = users.getUser().getRoles().getRolename();
		if(role.equals("USER")) {
			Driver driver = driverService.getDriverDetailsByLicense(users.getUser().getLicenseNumber());
		modelAndView.addObject("driver", driver);
		}
		modelAndView.addObject("role", role);
		modelAndView.setViewName("profile");
		return modelAndView;
	}
	
	

	@PostMapping("/updateDriver")
	public ModelAndView editDriverDetails(DriverDTO dto) {
		driverService.updateDriverDetails(dto);
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MyUserDetails users = (MyUserDetails) userService.loadUserByUsername(auth.getName());
		String role = users.getUser().getRoles().getRolename();
		if(role.equals("USER")) {
			Driver driver = driverService.getDriverDetailsByLicense(users.getUser().getLicenseNumber());
		modelAndView.addObject("driver", driver);
		}
		modelAndView.addObject("role", role);
		modelAndView.setViewName("profile");
		return modelAndView;
	}
	
	@GetMapping("/rentalDetails")
	public ModelAndView getRentalDetails() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MyUserDetails users = (MyUserDetails) userService.loadUserByUsername(auth.getName());
		Driver driver = driverService.getDriverDetailsByLicense(users.getUser().getLicenseNumber());
		List<RentalHistory> rentHistDetails = rentalHistoryRepo.getAllRentalDetailsByDriverId(driver.getDriverId());
		List<RentalDetails> rentDetails = new ArrayList<>();
		if(!CollectionUtils.isEmpty(rentHistDetails)) {
			for(RentalHistory rh : rentHistDetails) {
				RentalDetails rd= rentalDetailsMapper.toDto(rh);
				rentDetails.add(rd);
			}
		}
		modelAndView.addObject("rentalDetails", rentDetails);
		modelAndView.setViewName("rentalDetails");
		return modelAndView;
	}
	
}
