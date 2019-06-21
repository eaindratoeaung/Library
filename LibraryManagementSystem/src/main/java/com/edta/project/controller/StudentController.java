package com.edta.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edta.project.model.Student;
import com.edta.project.service.Library;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	@Autowired
	Library li;
	@RequestMapping(value="/student_list.htm")
	public String showStudentList(Model model){
		model.addAttribute("msg","Welcome");
		model.addAttribute("studentList", li.getStudents());
		return "student_list";
	}
	@RequestMapping(value="/create_student.htm")
	public String addStudent(Model model){
		model.addAttribute("msg","Welcome");
		model.addAttribute("student", new Student());
		return "create_student";
	}
	@RequestMapping(value="/create_student.htm",method=RequestMethod.POST)
	public String saveStudent(Model model,@ModelAttribute(value="student") Student std){
		try{
			li.saveStudent(std);
			return "redirect:/student_list.htm";
		}catch(Exception ex){
			return "create_student";
		}
	}
		@RequestMapping(value="/student_list.htm",method=RequestMethod.POST)
		public String showStudent(Model model,@ModelAttribute(value="student") Student std){
			model.addAttribute("studentList", li.getStudents());
				return "redirect:/student_list.htm";
	
		
	}
		@RequestMapping(value="/student/deleteStudent/{id}")
			public String delteStudent(Model model,@PathVariable(value="id")int id){
			li.deleteStudent(id);
			return "redirect:/studentList.htm";
		}
		@RequestMapping(value="/student/updateStudent/{id}")
		public String updateStudent(Model model,@PathVariable(value="id")int id){
			model.addAttribute("student",li.getStudentById(id) );
			return "create_student";
		}
		}
	
