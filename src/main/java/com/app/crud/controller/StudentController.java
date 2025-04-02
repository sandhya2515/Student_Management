package com.app.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.app.crud.model.Student;
import com.app.crud.service.StudentService;



@Controller
public class StudentController 
{
  @Autowired
  StudentService si;
  @GetMapping("/")
  public String homePage()
  {
	  return "home";
  }
  @GetMapping("/reg")
  public String getAllStudent(Model model)
  {
	  
	  return "register";
  }
  
  @PostMapping("/save")
  public String saveStud(@ModelAttribute Student s,Model m)
  {
      si.saveStudent(s);
	  m.addAttribute("MSG", "saved");
	  return "result";
  } 
 
  @GetMapping("/success")
  public String getStudents(@ModelAttribute Student s,Model model)
  {
	  List<Student>allStudents=si.getAllStudent();
	  model.addAttribute("data",allStudents);
	  return "success";
  }
  
  @GetMapping("/delete/{id}")
  public String deleteStudent(@PathVariable("id")Long id)
  {
	  si.deleteStudent(id);
	  return "redirect:/success";
  }
  
  @GetMapping("/reg_form/edit/{id}")
  public String editStudent(@PathVariable("id") Long id,Model m)
  {
	  Student s=si.getStudent(id);
	  m.addAttribute("data",s);	  
	  return "register";
  }

  @PostMapping("/reg_form/edit/{id}")
  public String postStudent(@PathVariable("id") Long id,Model m)
  {
	  si.addstudent(id);
	  m.addAttribute("MSG", "saved");
	  return "result";
  }
  
}
