package com.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.beans.MobileBean;
import com.google.gson.Gson;

@Controller
public class ProdPageController {
	
	@RequestMapping(value = "/mobile/{model1}", method = RequestMethod.GET)
	protected ModelAndView mobile(@PathVariable("model1") int model1, HttpServletResponse res, HttpSession httpSession){
		MobileBean mobile1;
		Configuration conf = new Configuration().configure().addAnnotatedClass(MobileBean.class);
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		mobile1 = (MobileBean) session.get(MobileBean.class, model1);
		tr.commit();
		session.close();
		ModelAndView mv = new ModelAndView("prodView");
		mv.addObject("name", mobile1.getModelName());
		mv.addObject("image", mobile1.getImgPath());
		mv.addObject("price", mobile1.getPrice());
		mv.addObject("availability", mobile1.isAvailability());
		mv.addObject("make", mobile1.getModelMake());
		mv.addObject("productId", mobile1.getProdId());
		/*ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		httpSession.setAttribute("productId", new Gson().toJson(mobile1));*/
		return mv;
	}
}