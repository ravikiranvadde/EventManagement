package com.adbms.fleetXpress.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.adbms.fleetXpress.dto.DriverDTO;
import com.adbms.fleetXpress.entity.User;
import com.adbms.fleetXpress.entity.Vehicle;
import com.adbms.fleetXpress.service.DriverService;
import com.adbms.fleetXpress.service.MyUserDetails;
import com.adbms.fleetXpress.service.UserDetailService;
import com.adbms.fleetXpress.service.VehicleService;

@Controller
public class LoginController {

	@Autowired
	UserDetailService userService;

	@Autowired
	VehicleService vehService;

	@Autowired
	DriverService driverService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping({ "/", "/login" })
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		String message = "Login if Existing User";
		modelAndView.addObject("message", message);
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@GetMapping("/registration")
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		User users = new User();
		modelAndView.addObject("user", users);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@GetMapping("/home")
	public ModelAndView adminHome() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MyUserDetails users = (MyUserDetails) userService.loadUserByUsername(auth.getName());
		modelAndView.addObject("userName", "Welcome " + users.getUsername());
		if (users.getUser().getRoles().getRolename().equals("ADMIN")) {
			modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
			modelAndView.setViewName("adminHome");
		} else {
			modelAndView.addObject("userName", "Welcome " + users.getUsername());
			List<Vehicle> vehicles = vehService.getAvailableVehicle();
			modelAndView.addObject("vehicles", vehicles);
			modelAndView.setViewName("home");

		}
		return modelAndView;
	}

	@PostMapping("/registration")
	public ModelAndView createNewUser(String username, String password, String roleName, String firstName,
			String lastName, String phone, String email, String licenseNumber, RedirectAttributes redirectAttributes) {
		String message = "";
		String pass = bCryptPasswordEncoder.encode(password);
		User users = new User();
		users.setUsername(username);
		users.setPassword(pass);

		ModelAndView modelAndView = new ModelAndView();
		User usersExists = userService.findByUserName(users.getUsername());
		if (usersExists != null) {
			message = "This User already exits";
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(users.getUsername(), users.getPassword(), roleName, firstName, lastName, phone, email,
					licenseNumber);
			if (roleName.equals("USER")) {
				DriverDTO driver = new DriverDTO();
				driver.setFirstName(firstName);
				driver.setLastName(lastName);
				driver.setLicenseNumber(licenseNumber);
				driver.setPhone(phone);
				driverService.saveDriver(driver);
			}
			modelAndView.addObject("successMessage", "Users has been registered successfully");
			modelAndView.addObject("user", new User());
			message = "User has been registered successfully";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("login");
		}
		redirectAttributes.addFlashAttribute("message", message);
		return modelAndView;
	}

}
