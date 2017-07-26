package com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.beans.KartBean;
import com.beans.MobileBean;

@Controller
@RequestMapping(value = "addProduct")
public class ProductAddController {
	
	@RequestMapping(value = "/mobile", method= RequestMethod.GET)
	protected ModelAndView addMobile() {
		
		MobileBean mobile1 = new MobileBean();
		mobile1.setProdId(1000);
		mobile1.setModelMake("Apple");
		mobile1.setModelName("6s");
		mobile1.setPrice(34999);
		mobile1.setImgPath("mob2.jpeg");
		mobile1.setAvailability(true);
		
		ModelAndView mv = new ModelAndView("prodAdd");

		try{
			Configuration conf = new Configuration().configure().addAnnotatedClass(MobileBean.class);
			SessionFactory sf = conf.buildSessionFactory();
			Session session = sf.openSession();
			Transaction tr = session.beginTransaction();
			session.save(mobile1);
			tr.commit();
			session.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		mv.addObject("status", "Success");
		return mv;
	}
}
