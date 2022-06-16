package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.entity.Student;

@SpringBootApplication
public class SpringBootProject1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext c= SpringApplication.run(SpringBootProject1Application.class, args);
		Student s=c.getBean(Student.class);
		s.display();
	}

}
