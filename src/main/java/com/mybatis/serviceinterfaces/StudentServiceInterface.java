package com.mybatis.serviceinterfaces;

import java.util.List;

import com.mybatis.model.Student;

public interface StudentServiceInterface {
	public void add(Student student);
	public void edit(Student student);
	public void delete(int studentId);
	public Student getStudent(int studentId);
	public List<Student> getAllStudent();

	
}
