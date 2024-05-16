package com.adbms.fleetXpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adbms.fleetXpress.entity.Roles;
import com.adbms.fleetXpress.entity.User;
import com.adbms.fleetXpress.repo.RolesRepo;
import com.adbms.fleetXpress.repo.UserRepo;

@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo userRepository;

	@Autowired
	private RolesRepo roleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}

		return new MyUserDetails(user);
	}

	public User findByUserName(String username) {
		User user = userRepository.findByUserName(username);
		return user;
	}

	public Roles getRole(String role) {
		return roleRepository.findRoleByName(role);
	}

	public void saveUser(String username, String password, String role, String firstName, String lastName, String phone,
			String email, String licenseNumber ) {
		Roles roles = new Roles();
		roles = getRole(role);
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRoles(roles);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPhone(phone);
		user.setLicenseNumber(licenseNumber);
		userRepository.save(user);
	}

}
