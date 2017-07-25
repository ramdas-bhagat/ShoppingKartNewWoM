package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.beans.StudentBean;

@RestController
public class RESTApiTestController {
	
	@RequestMapping(value = "/getKartItems.htm", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
	public void getItems(HttpServletResponse res) throws IOException{
		System.out.println("hello world");
		ArrayList<StudentBean> items = new ArrayList<>();
		
		StudentBean s1 = new StudentBean();
		s1.setStudName("Ramdas");
		
		items.add(s1);
		
		//res.getWriter().write(new Gson().toJson(items));
		String[] itemsString = {s1.toString(), s1.toString()};
		//return new ResponseEntity<StudentBean>(s1, HttpStatus.OK);
		//return items;
	}
}
