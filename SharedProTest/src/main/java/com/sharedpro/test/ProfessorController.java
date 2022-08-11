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
public class ProfessorController {
	@Autowired
	private ProfessorService service;
	@GetMapping("/professor")
	public List<Professor>list()
	{
		return service.listAll();
	}
	//retrieve a specific records from database
		@GetMapping("/professor/{id}")
		public ResponseEntity<Professor>get(@PathVariable Integer id)
		{
			try
			{
				Professor professor=service.get(id);
				return new ResponseEntity<Professor>(professor,HttpStatus.OK);
			}
			catch(NoSuchElementException e)
			{
				return new ResponseEntity<Professor>(HttpStatus.NOT_FOUND);
			}
			
		}
		
		//creation of rows
		@PostMapping("/professor")
		public ResponseEntity<Professor> add(@RequestBody Professor professor)
		{
			Professor savedProfessor = service.saveProfessor(professor);
			return new ResponseEntity<Professor>(savedProfessor,HttpStatus.OK);
		}
		//update
		@PutMapping("/professor/{id}")
		public ResponseEntity<?>update(@RequestBody Professor professor,@PathVariable Integer id)
		{
			try
			{
				@SuppressWarnings("unused")
				Professor professor1=service.get(id);
				service.save(professor);
				return new ResponseEntity<>(professor,HttpStatus.OK);
			}
			catch(NoSuchElementException e)
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		}
		//delete
		@DeleteMapping("/professor/{id}")
		public void delete(@PathVariable Integer id)
		{
			service.delete(id);
		}

}
