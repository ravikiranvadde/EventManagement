package com.adbms.fleetXpress.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adbms.fleetXpress.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	@Query(value = "select u from User u where u.username = :username")
	public User findByUserName(String username);

}
