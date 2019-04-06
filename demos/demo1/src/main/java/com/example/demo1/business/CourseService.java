package com.example.demo1.business;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo1.persistence.entity.Course;
import com.example.demo1.persistence.repo.CourseRepository;

@Service()
public class CourseService {

	@Inject
	CourseRepository courseRepository;
	
	
	public List<Course> getAllCourses()
	{
		return courseRepository.findAll();
	}
	
	
	public List<Course> getAllCoursesByTeacherFirstName(String firstName)
	{
		List<Course> coursesFilteredList = null;
		
		if (StringUtils.isEmpty(firstName))
		{
			coursesFilteredList = courseRepository.findAll();
		}
		else
		{
			coursesFilteredList = courseRepository.findAllByTeacherFirstName(firstName);
		}
		
		return coursesFilteredList;
	}
}
