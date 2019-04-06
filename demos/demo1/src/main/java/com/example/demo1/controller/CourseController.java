package com.example.demo1.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo1.business.CourseService;
import com.example.demo1.persistence.entity.Course;

@Controller
public class CourseController {

	
	@Inject
	private CourseService courseService;
	
    @RequestMapping(value =  "/courses", method = RequestMethod.GET)
	public ModelAndView getCourses(@RequestParam(name = "fn", required = false) String firstName)
	{
    	List<Course> courseList = courseService.getAllCoursesByTeacherFirstName(firstName);
    	
    	ModelAndView mav = new ModelAndView("course_view");
    	mav.addObject("courseWithTeachersList", courseList);
    	
    	return mav;
	}

}
