package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.beans.KartBean;
import com.beans.UserBean;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "userController")
public class UserController {

	Configuration conf = new Configuration().addAnnotatedClass(UserBean.class).addAnnotatedClass(KartBean.class)
			.configure();
	SessionFactory sf = conf.buildSessionFactory();

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public void addUser(@RequestParam HashMap<String, String> reqParams, HttpServletResponse res) throws IOException {
		System.out.println("In add user!!");
		UserBean user = new UserBean();

		/*
		 * user.setUserID("ram222"); user.setUserName("Ramdas Bhagat");
		 * user.setPassword("ram123");
		 */
		System.out.println("Adding user "+ reqParams.get("uId"));
		user.setUserID(reqParams.get("uId"));
		user.setUserName(reqParams.get("uName"));
		user.setPassword(reqParams.get("passwd"));
		KartBean kart = new KartBean();
		kart.setKartId(reqParams.get("uId"));
		user.setKart(kart);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		session.save(kart);
		tx.commit();
		session.close();
		res.getWriter().write(new Gson().toJson("Success"));
	}
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public void getAllUser(HttpServletResponse res) throws IOException {
		System.out.println("In add user!!");

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from UserBean");
		ArrayList<UserBean> users = (ArrayList<UserBean>) query.list();
		tx.commit();
		session.close();
		res.getWriter().write(new Gson().toJson(users));
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public void updateUser(@RequestParam HashMap<String, String> reqParams, HttpServletResponse res)
			throws IOException {
		System.out.println(reqParams.get("uId"));
		UserBean user = null;
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		if (reqParams.get("uName") != null && reqParams.get("uName") != "") {
			if (reqParams.get("passwd") != null && reqParams.get("passwd") != "") {
				user = session.get(UserBean.class, reqParams.get("uId"));
				KartBean kart = session.get(KartBean.class, reqParams.get("uId"));
				user.setUserName(reqParams.get("uName"));
				user.setPassword(reqParams.get("passwd"));
				session.update(user);
				session.update(kart);
			}else {
				System.out.println("In username update!!");
				user = session.get(UserBean.class, reqParams.get("uId"));
				user.setUserName(reqParams.get("uName"));
				session.update(user);
			}
		}  else if (reqParams.get("passwd") != null && reqParams.get("passwd") != "") {
			System.out.println("In password update");
			user = session.get(UserBean.class, reqParams.get("uId"));
			user.setPassword(reqParams.get("passwd"));
			session.update(user);
		}
		tx.commit();
		session.close();
		res.getWriter().write(new Gson().toJson("Success"));
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public void deleteUser(@RequestParam HashMap<String, String> reqParams, HttpServletResponse res)
			throws IOException {
		System.out.println("In delete usesr Deleting User " + reqParams.get("uId"));

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		// session.delete("ram222");
		session.delete(session.get(UserBean.class, reqParams.get("uId")));
		session.delete(session.get(KartBean.class, reqParams.get("uId")));
		/*
		 * Query query =
		 * session.createQuery("delete from UserBean where userID = :uId");
		 * query.setParameter("uId", reqParams.get("uName"));
		 * query.executeUpdate();
		 */
		tx.commit();
		session.close();
		res.getWriter().write(new Gson().toJson("Success"));
	}
}
