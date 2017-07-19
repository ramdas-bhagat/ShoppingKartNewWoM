package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beans.StudentBean;

@RestController
public class RESTApiTestController {
	
	@RequestMapping(value = "/getKartItems.htm", method = RequestMethod.GET)
	public StudentBean getItems(HttpServletResponse res) throws IOException{
		ArrayList<StudentBean> items = new ArrayList<>();
		
		StudentBean s1 = new StudentBean();
		s1.setStudName("Ramdas");
		
		items.add(s1);
		
		//res.getWriter().write(new Gson().toJson(items));
		String[] itemsString = {s1.toString(), s1.toString()};
		return s1;
	}
}
