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
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	@GetMapping("/department")
	public List<Department>list()
	{
		return service.listAll();
	}
	//retrieve a specific records from database
		@GetMapping("/department/{id}")
		public ResponseEntity<Department>get(@PathVariable Integer id)
		{
			try
			{
				Department department=service.get(id);
				return new ResponseEntity<Department>(department,HttpStatus.OK);
			}
			catch(NoSuchElementException e)
			{
				return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
			}
			
		}
		
		//creation of rows
		@PostMapping("/department")
		public void add(@RequestBody Department department)
		{
			service.save(department);
		}
		
		//update
		@PutMapping("/department/{id}")
		public ResponseEntity<?>update(@RequestBody Department department,@PathVariable Integer id)
		{
			try
			{
				@SuppressWarnings("unused")
				Department department1=service.get(id);
				service.save(department);
				return new ResponseEntity<>(department,HttpStatus.OK);
			}
			catch(NoSuchElementException e)
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		}
		
		//delete
		@DeleteMapping("/department/{id}")
		public void delete(@PathVariable Integer id)
		{
			service.delete(id);
		}
		

}
