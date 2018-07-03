package com.mybatis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mybatis.model.Student;
import com.mybatis.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentservice;
	
	@RequestMapping("/index")
	public String setupForm(Map<String, Object> map){
		Student student = new Student();
		map.put("student", student);
		//map.put("studentList", studentservice.getAllStudent());
		return "student";
	}
	@RequestMapping(value="/student.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Student student, BindingResult result, @RequestParam String action, Map<String, Object> map){
		Student studentResult = new Student();
		switch(action.toLowerCase()){	//only in Java7 you can put String in switch
		case "add":
			studentservice.add(student);
			studentResult = student;
			break;
		case "edit":
			studentservice.edit(student);
			studentResult = student;
			break;
		case "delete":
			studentservice.delete(student.getStudentid());
			studentResult = new Student();
			break;
		
		}
		map.put("student", studentResult);
		map.put("studentList",studentservice.getAllStudent());
		//map.put("minombre", "Jose");
		
		return "student";
	}
}
