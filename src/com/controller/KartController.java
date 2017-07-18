package com.controller;

import java.io.IOException;
import java.util.ArrayList;
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
@RequestMapping(value="kartController", method= RequestMethod.GET)
public class KartController {
	
	@RequestMapping(value="/addToKart.htm", method = RequestMethod.GET)
	public void addToKart(@RequestParam HashMap<String, String> params, HttpServletResponse res) throws IOException{
		System.out.println("Product Id: "+ params.get("productId")+" User Name: "+params.get("userID"));
		
		Configuration conf = new Configuration().addAnnotatedClass(UserBean.class).addAnnotatedClass(KartBean.class).configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		KartBean kart = session.get(KartBean.class, params.get("userID"));
		
		int noOfProducts = kart.getNoOfProducts() + 1;
		kart.setNoOfProducts(noOfProducts);
		ArrayList<Integer> prodList = kart.getProducts();
		prodList.add(Integer.parseInt(params.get("productId")));
		kart.setProducts(prodList);
		
		session.save(kart);
		tx.commit();
		session.close();
		res.getWriter().write(new Gson().toJson("added to kart"));
	}
	
	@RequestMapping(value="/kartStatus.htm", method= RequestMethod.GET)
	public void kartStstus(HttpServletResponse res, @RequestParam("uName") String uName) throws IOException{
		Configuration conf = new Configuration().addAnnotatedClass(KartBean.class).configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		KartBean kart = session.get(KartBean.class, uName);
		tx.commit();
		session.close();
		
		HashMap<String, Object> resMap = new HashMap<>();
		resMap.put("noItems", kart.getNoOfProducts());
		resMap.put("product", kart.getProducts());
		res.getWriter().write(new Gson().toJson(resMap));
	}
}
