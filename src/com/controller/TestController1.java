package com.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beans.TestBean;

@RestController
public class TestController1 {
	@RequestMapping(value="test1.htm",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public String getBeans(){
		System.out.println("inside test1.htm");
		TestBean t = new TestBean();
		t.setId(1);
		t.setName("test");
		return "test";
	}
}
