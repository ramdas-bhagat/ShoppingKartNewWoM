package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beans.KartBean;
import com.beans.UserBean;
import com.google.gson.Gson;

@Controller
@RequestMapping(value="kartController")
public class KartController {
	
	@RequestMapping(value="/addToKart", method = RequestMethod.GET)
	public void addToKart(@RequestParam HashMap<String, String> params, HttpServletResponse res, HttpServletRequest req) throws IOException{
		System.out.println("Product Id: "+ params.get("productId")+" User Name: "+params.get("uId"));
		
		Configuration conf = new Configuration().addAnnotatedClass(UserBean.class).addAnnotatedClass(KartBean.class).configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		KartBean kart = session.get(KartBean.class, params.get("uId"));
		
		HashMap<Integer, Integer> prodList = kart.getProducts();
		int prodId = Integer.parseInt(params.get("productId"));
		if(prodList.containsKey(prodId))
		{
			prodList.put(prodId, (prodList.get(Integer.parseInt(params.get("productId"))) + 1));
		}else{
			prodList.put(Integer.parseInt(params.get("productId")), 1);
			int noOfProducts = kart.getNoOfProducts() + 1;
			kart.setNoOfProducts(noOfProducts);
		}
		kart.setProducts(prodList);
		
		session.save(kart);
		tx.commit();
		session.close();
		res.getWriter().write(new Gson().toJson("added to kart"));
	}
	
	@ResponseBody
	@RequestMapping(value="/kartStatus", method= RequestMethod.GET)
	public HashMap<String, Object> kartStstus(HttpServletResponse res, @RequestParam("uId") String uId) throws IOException{
		Configuration conf = new Configuration().addAnnotatedClass(KartBean.class).configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		KartBean kart = session.get(KartBean.class, uId);
		tx.commit();
		session.close();
		
		HashMap<String, Object> resMap = new HashMap<>();
		resMap.put("noItems", Integer.toString(kart.getNoOfProducts()));
		resMap.put("product", kart.getProducts());
		//resMap.putAll(kart.getProducts());
		//res.getWriter().write(new Gson().toJson(resMap));
		return resMap;
	}
	
	/*@ExceptionHandler(value = Exception.class)
	public String exceptionHandler(Exception e){
		System.out.println("Exception occured "+ e.getMessage());
		return "error";
	}*/
	
}
