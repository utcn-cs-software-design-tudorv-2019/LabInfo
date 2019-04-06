package com.example.demo1.business;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.demo1.persistence.entity.Teacher;
import com.example.demo1.persistence.repo.TeacherRepository;

@Service
public class TeacherService {

	private int count;
	
	@Inject
	TeacherRepository teacherRepository;
	
	public List<Teacher> getAllTeachersWithCourses()
	{
		return teacherRepository.findAll();
	}
	
	public Teacher create(Teacher newTeacher)
	{
		return teacherRepository.save(newTeacher);
	}
}
