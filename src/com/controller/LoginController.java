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
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.beans.KartBean;
import com.beans.UserBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class LoginController {
	
	@RequestMapping(value="/userLogin", method = RequestMethod.GET)
	public void userLogin(@RequestParam HashMap<String, String> params, HttpServletResponse res, HttpServletRequest req, HttpSession httpSession, Model model) throws IOException{
		System.out.println("in Login controller!!");
		Configuration conf = new Configuration().addAnnotatedClass(UserBean.class).addAnnotatedClass(KartBean.class).configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		UserBean user = session.get(UserBean.class, params.get("uName"));
		KartBean kart = session.get(KartBean.class, params.get("uName"));
		
		System.out.println(req.getParameter("uName"));
		
		tx.commit();
		session.close();
		Gson gson = new GsonBuilder().serializeNulls().create();
		
		if(user != null){
			HashMap<String, String> resMap = new HashMap<>();
			resMap.put("userId", user.getUserID());
			resMap.put("userName", user.getUserName());
			
			httpSession.setAttribute("uName", user.getUserName());
			httpSession.setAttribute("uId", user.getUserID());
			httpSession.setAttribute("kartNo", kart.getNoOfProducts());
			resMap.put("kartItems",	Integer.toString(kart.getNoOfProducts()));
			
			model.addAllAttributes(resMap);
			res.getWriter().write(gson.toJson(resMap));
			
		}else {
			res.getWriter().write(gson.toJson("failed"));
		}
	}
	
	@RequestMapping(value="/checkLogin")
	public void checkLogin(HttpServletRequest req, HttpServletResponse res) throws IOException{
		/* Cookie[] cookieList = req.getCookies();
		 * for(Cookie c : cookieList){
			System.out.println("cookie name "+c.getName());
			if(c.getName().equals("shopLogin")){
				status = c.getValue();
			}
		}*/
		/*System.out.println(req.getSession());
		session.invalidate();
		System.out.println(req.getSession());*/
		HttpSession session = req.getSession(false);
		//session.invalidate();
		/*session = req.getSession(false);
		System.out.println(session);
		session.invalidate();
		System.out.println(session);*/
		String uname = (String) session.getAttribute("uName");
		System.out.println("Uname "+ uname);
		String s = "";
		if(uname != null){
			s = "Logged In";
		}else{
			s = "Logged out";
		}
		res.getWriter().write(new Gson().toJson(s));
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public void logout(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws IOException{
		session.invalidate();
		res.getWriter().write(new Gson().toJson("Logged out successfully"));
	}
}
