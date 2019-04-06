package com.example.demo1;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.example.demo1.persistence.entity.Course;
import com.example.demo1.persistence.entity.Teacher;
import com.example.demo1.persistence.repo.CourseRepository;
import com.example.demo1.persistence.repo.TeacherRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersistenceTests {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void findAllTeachers_notEmpty() {
		
		List<Teacher> teacherList = teacherRepository.findAll();
		
		Assert.notEmpty(teacherList);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void findAllCourses_notEmpty() {
		
		List<Course> courseList = courseRepository.findAllByTeacherFirstName("timo");
		
		Assert.notEmpty(courseList);
	}

}
