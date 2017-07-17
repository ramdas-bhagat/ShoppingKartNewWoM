package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.beans.KartBean;
import com.beans.UserBean;
import com.sun.javafx.collections.MappingChange.Map;


@Controller
@RequestMapping(value = "userController")
public class UserController {
	
	@RequestMapping(value = "/addUser.htm", method = RequestMethod.GET)
	public ModelAndView addUser(){
		System.out.println("In add user!!");
		UserBean user =  new UserBean();
		
		user.setUserID("ram.bhagat222@gmail.com");
		user.setUserName("Ramdas Bhagat");
		user.setPassword("ram123");
		
		KartBean kart = new KartBean();
		kart.setKartId("ram.bhagat222@gmail.com");
		user.setKart(kart);
		kart.setUser(user);
		
		
		Configuration conf = new Configuration().addAnnotatedClass(UserBean.class).addAnnotatedClass(KartBean.class).configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		session.save(kart);
		tx.commit();
		session.close();
		return null;
		
	}
}