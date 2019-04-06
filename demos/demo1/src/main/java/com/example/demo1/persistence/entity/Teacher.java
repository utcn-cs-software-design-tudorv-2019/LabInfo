package com.example.demo1.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    @Column
    private String firstName;
	
    @Column
	private String lastName;
	
    @Column
	private String email;
	
    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
    private List<Course> courses;



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public List<Course> getCourses() {
		return courses;
	}



	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}



	@Override
	public String toString() {
		return "teacher[" + id + "] " + firstName + " " + lastName;
	}

   
    
    
}
