package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="kartController", method= RequestMethod.GET)
public class KartController {
	
	@RequestMapping(value="/addToKart", method = RequestMethod.GET)
	public void addToKart(){
		
	}
}
