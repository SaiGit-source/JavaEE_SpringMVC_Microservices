package com.WithReact.StudentUI.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WithReact.StudentUI.model.Student;

public interface IStudentRepo extends JpaRepository<Student, Long> {

}
