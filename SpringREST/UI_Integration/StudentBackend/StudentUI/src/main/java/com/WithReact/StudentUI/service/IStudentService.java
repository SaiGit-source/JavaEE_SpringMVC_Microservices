package com.WithReact.StudentUI.service;

import java.util.List;

import com.WithReact.StudentUI.model.Student;

public interface IStudentService {

	public List<Student> getAllStudents();
	public Student saveStudent(Student student);
	public Student getStudentById(Long id);
	public Student updateStudent(Student student);
	public void deleteStudentById(Long id);

}
