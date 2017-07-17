package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.beans.KartBean;
import com.beans.UserBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class LoginController {
	
	@RequestMapping(value="/userLogin.htm", method = RequestMethod.GET)
	public void userLogin(@RequestParam HashMap<String, String> params, HttpServletResponse res, HttpSession httpSession) throws IOException{
		System.out.println("in Login controller!!");
		Configuration conf = new Configuration().addAnnotatedClass(UserBean.class).addAnnotatedClass(KartBean.class).configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		UserBean user = session.get(UserBean.class, params.get("uName"));
		tx.commit();
		session.close();
		Gson gson = new GsonBuilder().serializeNulls().create();
		
		if(user != null){
			HashMap<String, String> resMap = new HashMap<>();
			resMap.put("userId", user.getUserID());
			resMap.put("userName", user.getUserName());
			httpSession.setAttribute("uName", user.getUserName());
			httpSession.setAttribute("uId", user.getUserID());
			resMap.put("kartItems",	Integer.toString(user.getKart().getNoOfProducts()));
			Cookie cookie = new Cookie("shopLogin", "true");
			System.out.println(user.toString());
			res.getWriter().write(gson.toJson(resMap));
			res.addCookie(cookie);
		}else {
			res.getWriter().write(gson.toJson("failed"));
		}
	}
	
	@RequestMapping(value="/checkLogin.htm")
	public void checkLogin(HttpServletRequest req, HttpServletResponse res, SessionStatus sessionStatus) throws IOException{
		Cookie[] cookieList = req.getCookies();
		String status = null;
		for(Cookie c : cookieList){
			if(c.getName() == "shopLogin"){
				status = c.getValue();
			}
		}
		if(status != null){
			res.getWriter().write(new Gson().toJson("Logged In"));
		}else{
			res.getWriter().write(new Gson().toJson("Logged out"));
		}
	}
}
