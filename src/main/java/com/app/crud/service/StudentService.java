package com.app.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.crud.model.Student;
import com.app.crud.repo.StudentRepo;

@Service
public class StudentService 
{
  @Autowired
  StudentRepo sr;
  public void saveStudent(Student s)
  {
	  sr.save(s);
  }
  
  public List<Student> getAllStudent()
  {
	  return (List<Student>)sr.findAll();
  }
  
  public void deleteStudent(Long id)
  {
	   sr.deleteById(id);
  }
  
  public Student getStudent(Long id)
  {
	  return sr.findById(id).get();
  }
  
  public void addstudent(Long id)
  {
	  Student s = new Student();
	  s.setId(id);
	   sr.save(s);
  }
};
