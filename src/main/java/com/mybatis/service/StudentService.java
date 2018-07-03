package com.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.model.Student;
import com.mybatis.serviceinterfaces.StudentServiceInterface;

@Service
public class StudentService {

	@Autowired
	private StudentServiceInterface studentserviceinterface;
	
	@Transactional
	public void add(Student s) {
		studentserviceinterface.add(s);
	}
	@Transactional
	public void edit(Student s) {
		studentserviceinterface.edit(s);
	}
	@Transactional
	public void delete(int id) {
		studentserviceinterface.delete(id);
	}
	@Transactional
	public Student getStudent(int id) {
		return studentserviceinterface.getStudent(id);
	}
	@Transactional
	public List getAllStudent(){
		return studentserviceinterface.getAllStudent();
	}

}
