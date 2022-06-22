package com.cg.placementmanagement;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="certificate")
public class Certificate implements Serializable {
	private static final long serialVersionUID=1L;
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private int year;
	private String college;
	public Certificate() {
		super();
		
	}
	public Certificate(long id, int year, String college) {
		super();
		this.id = id;
		this.year = year;
		this.college = college;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	
	

}