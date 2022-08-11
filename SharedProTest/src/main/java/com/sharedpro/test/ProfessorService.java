package com.sharedpro.test;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProfessorService {
	@Autowired
	private ProfessorRepo repo;

	@Autowired
	private DepartmentService depService;
	
	//to retrieve a data
	public List<Professor> listAll() {
		
		return repo.findAll();
	}
	//to retrieve a specific row
	public Professor get(Integer id) {
		
		return repo.findById(id).get();
	}
	//create
	public Professor save(Professor professor) {
		return repo.save(professor);
		
	}
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	public Professor saveProfessor(Professor professor) {
    	String depName = professor.getDepartment().getName();
		Department dep = depService.getByName(depName);
		if(dep != null) {
			professor.setDepartment(dep);
			return save(professor);
		} else {
			return save(professor);
		}
    }

}
