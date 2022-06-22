package com.cg.placementmanagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class College {
    private Integer id;
    private String collegeAdmin;
    private String collegeName;
    private String location;
    public College() {
    }
 
    public College(Integer id, String collegeadmin, String collegename, String location) {
        this.id = id;
        this.collegeAdmin = collegeadmin;
        this.collegeName = collegename;
        this.location = location;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCollegeadmin() {
		return collegeAdmin;
	}

	public void setCollegeadmin(String collegeadmin) {
		this.collegeAdmin = collegeadmin;
	}

	public String getCollegename() {
		return collegeName;
	}

	public void setCollegename(String collegename) {
		this.collegeName = collegename;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", collegeadmin=" + collegeAdmin + ", collegename=" + collegeName + ", location="
				+ location + "]";
	}

	
   
	
	
	

	
	
}
