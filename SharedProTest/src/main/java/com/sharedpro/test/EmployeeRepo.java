package com.sharedpro.test;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
	public List<Employee> findByOrderByNameAsc();
	public List<Employee> findByOrderByNameDesc();
	public List<Employee> findByOrderByCityAsc();
	public List<Employee> findByOrderByCityDesc();
	public List<Employee> findByOrderByBirthdayAsc();
	public List<Employee> findByOrderByBirthdayDesc();
}
