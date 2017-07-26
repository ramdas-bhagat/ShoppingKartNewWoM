package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


public class WelComeController {
	
	public String welComeMethod(){
		return "index";
	}
}
