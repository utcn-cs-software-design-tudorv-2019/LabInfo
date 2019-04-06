package com.example.demo1.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo1.persistence.entity.Course;


public interface CourseRepository extends JpaRepository<Course, Integer>{

	
	public List<Course> findAllByTeacherFirstName(String firstName);
}
