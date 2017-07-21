package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beans.TestBean;
import com.google.gson.Gson;

@RestController
public class TestController1 {
	@RequestMapping(value="test1.htm",method=RequestMethod.GET)
	public void getBeans(HttpServletResponse res) throws IOException{
		System.out.println("inside test1.htm");
		TestBean t = new TestBean();
		t.setId(1);
		t.setName("test");
		Gson gson = new Gson();
		res.getWriter().write(gson.toJson(t));
	}
}
