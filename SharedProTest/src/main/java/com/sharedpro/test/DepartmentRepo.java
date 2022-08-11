package com.sharedpro.test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Integer> {
	public Department findOneByName(String name);
}
