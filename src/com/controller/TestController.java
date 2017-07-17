package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping(value = "/welcome.htm", method = RequestMethod.GET)
	protected ModelAndView welcomeController(){
		System.out.println("In controller");
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("headerMsg", "Wel-Come to Shopping Mart");
		return mv;
	}

}
