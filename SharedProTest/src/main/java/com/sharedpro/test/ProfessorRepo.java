package com.sharedpro.test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepo extends JpaRepository<Professor,Integer> {
	
}
