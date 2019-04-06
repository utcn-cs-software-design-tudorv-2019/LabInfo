package com.example.demo1.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo1.business.TeacherService;
import com.example.demo1.persistence.entity.Teacher;

@Controller
public class TeacherController {

	@Inject
	TeacherService teacherService;
	
    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
	public ModelAndView getTeachers()
	{
    	List<Teacher> teacherList = teacherService.getAllTeachersWithCourses();
    	
    	
    	ModelAndView mav = new ModelAndView("teacher_view");
    	mav.addObject("teachersWithCoursesList", teacherList);
    	
    	return mav;

	}
    
    
    @RequestMapping(value = "/teachers", method = RequestMethod.POST)
	public ModelAndView postTeacher(@ModelAttribute(value = "newTeacher") Teacher newTeacher)
	{
    	teacherService.create(newTeacher);
    	
    	return new ModelAndView("redirect:teachers");

	}

}
