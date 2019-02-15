package com.capgemini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.model.User;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/")
	public String getHome(){
		return "index";
	}

	@PostMapping(value="/save")
	public ModelAndView login(@ModelAttribute User user){
		
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("user",user);
		modelAndView.setViewName("user-data");
		
		return modelAndView;
	}

}
