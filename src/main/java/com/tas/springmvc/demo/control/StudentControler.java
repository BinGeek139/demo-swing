package com.tas.springmvc.demo.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tas.springmvc.demo.model.dao.impl.StudentDao;
import com.tas.springmvc.demo.model.entiy.Student;

@Controller
public class StudentControler {
	@Autowired
	StudentDao st;

	@RequestMapping("/")
	public String index(ModelMap model) {
		String heading = "Spring MVC: How to Access ModelMap Values in a JSP?";
		String result1 = "Hey.. I'm result1.. You are seeing me on welcome page.";
		String result2 = "Hey.. I'm result2.. ";
 
		String credit = "Demo by <a href='https://crunchify.com'>Crunchify</a>. Click <a href='https://crunchify.com/category/java-tutorials/'>here</a> for more than 350 Java Examples.";
 
		// you can add any Collection Objects to ModelMap
		// including JSON, String, Array, Map, List, etc...
		model.addAttribute("heading", heading);
		model.addAttribute("result1", result1);
		model.addAttribute("result2", result2);
		model.addAttribute("credit", credit);
		return "index";
	}

}
