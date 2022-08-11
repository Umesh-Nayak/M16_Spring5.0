package com.sharedpro.test;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class DepartmentService {
	@Autowired
	private DepartmentRepo repo;
	//to retrieve a data
	public List<Department> listAll() {
		
		return repo.findAll();
	}
	//to retrieve a specific row
	public Department get(Integer id) {
		
		return repo.findById(id).get();
	}
	//create
	public void save(Department department) {
		 repo.save(department);
		
	}
	public void delete(Integer id) {
		repo.deleteById(id);
	}

	
	public Department getByName(String depName) {
		return repo.findOneByName(depName);

	}
}
