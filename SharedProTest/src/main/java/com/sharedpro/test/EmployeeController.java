package com.sharedpro.test;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employee")
	public List<Employee>list()
	{
		return service.listAll();
	}
	
	@GetMapping("/employeeByAsc")
	public List<Employee> sortByNameAsc()
	{
		return service.sortByNameAsc();
	}
	
	@GetMapping("/employeeByDesc")
	public List<Employee> sortByNameDesc()
	{
		return service.sortByNameDesc();
	}
	
	@GetMapping("/employeeByCityAsc")
	public List<Employee> sortByCityAsc()
	{
		return service.sortByCityAsc();
	}
	
	@GetMapping("/employeeByCityDesc")
	public List<Employee> sortByCityDesc()
	{
		return service.sortByCityAsc();
	}
	
	@GetMapping("/employeeByBirthdayAsc")
	public List<Employee> sortByBirthdayAsc()
	{
		return service.sortByBirthdayAsc();
	}
	
	@GetMapping("/employeeByBirthdayDesc")
	public List<Employee> sortByBirthdayDesc()
	{
		return service.sortByBirthdayAsc();
	}
	
	//retrieve a specific records from database
		@GetMapping("/employee/{id}")
		public ResponseEntity<Employee>get(@PathVariable Integer id)
		{
			try
			{
				Employee employee=service.get(id);
				return new ResponseEntity<Employee>(employee,HttpStatus.OK);
			}
			catch(NoSuchElementException e)
			{
				return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
			}
			
		}
		//creation of rows
		@PostMapping("/employee")
		public ResponseEntity<Employee> add(@RequestBody Employee employee)
		{
			Employee savedEmployee = service.saveEmployee(employee);
			return new ResponseEntity<Employee>(savedEmployee,HttpStatus.OK);
		}
		
		//update
		@PutMapping("/employee/{id}")
		public ResponseEntity<?>update(@RequestBody Employee employee,@PathVariable Integer id)
		{
			try
			{
				@SuppressWarnings("unused")
				Employee existEmployee=service.get(id);
				service.save(employee);
				return new ResponseEntity<>(employee,HttpStatus.OK);
			}
			catch(NoSuchElementException e)
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		}
		//delete
		@DeleteMapping("/employee/{id}")
		public void delete(@PathVariable Integer id)
		{
			service.delete(id);
		}

}
