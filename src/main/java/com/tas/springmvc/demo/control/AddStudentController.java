package com.tas.springmvc.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tas.springmvc.demo.model.dao.impl.StudentDao;
import com.tas.springmvc.demo.model.entiy.Student;
import com.tas.springmvc.demo.model.entiy.StudentWapper;
@Controller
public class AddStudentController  {
	@Autowired
	StudentDao st;
	@RequestMapping("/add")
	public String add(Model model) {
		  model.addAttribute("command", new StudentWapper());  
		return "ViewAdd";
	}
	@RequestMapping(value = {"/addStudent"} ,method = RequestMethod.POST)
	public String addStudentDatabase(@ModelAttribute("stu") StudentWapper student) {
		
		st.add(student.toStudent());
		return "redirect: add";
	}
	
	
}
