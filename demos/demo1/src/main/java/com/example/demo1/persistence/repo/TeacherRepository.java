package com.example.demo1.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo1.persistence.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
	
	

}
