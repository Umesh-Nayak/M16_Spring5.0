package com.sharedpro.test;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeService {
	@Autowired
	private EmployeeRepo repo;
	
	@Autowired
	private DepartmentService depService;
    
    public List<Employee> listAll() {
        return repo.findAll();
    }
      
    public Employee get(Integer id) {
        return repo.findById(id).get();
    }
    public Employee save(Employee employee) {
		 return repo.save(employee);
    }
    public void delete(Integer id) {
    	repo.deleteById(id);
    }
    
    public List<Employee> sortByNameAsc() {
    	return repo.findByOrderByNameAsc();
    }
    
    public List<Employee> sortByNameDesc() {
    	return repo.findByOrderByNameDesc();
    }
    
    public List<Employee> sortByCityAsc() {
    	return repo.findByOrderByCityAsc();
    }
    
    public List<Employee> sortByCityDesc() {
    	return repo.findByOrderByCityDesc();
    }
    
    public List<Employee> sortByBirthdayAsc() {
    	return repo.findByOrderByBirthdayAsc();
    }
    
    public List<Employee> sortByBirthdayDesc() {
    	return repo.findByOrderByBirthdayDesc();
    }
    
    public Employee saveEmployee(Employee employee) {
    	String depName = employee.getDepartment().getName();
		Department dep = depService.getByName(depName);
		if(dep != null) {
			employee.setDepartment(dep);
			return save(employee);
		} else {
			return save(employee);
		}
    }

}
