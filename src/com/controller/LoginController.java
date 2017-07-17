package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.beans.KartBean;
import com.beans.UserBean;
import com.google.gson.Gson;

@Controller
public class LoginController {
	
	@RequestMapping(value="/userLogin.htm", method = RequestMethod.GET)
	public void userLogin(@RequestParam HashMap<String, String> params, HttpServletResponse res) throws IOException{
		System.out.println("in Login controller!!");
		Configuration conf = new Configuration().addAnnotatedClass(UserBean.class).addAnnotatedClass(KartBean.class).configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		UserBean user = session.get(UserBean.class, params.get("uName"));
		tx.commit();
		session.close();
		
		if(user != null){
			System.out.println(user.toString());
			res.getWriter().write(new Gson().toJson(user.toString()));
		}else{
			res.getWriter().write(new Gson().toJson("failed"));
		}
	}
}
