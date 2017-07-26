package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.beans.StudentBean;

@RestController
public class RESTApiTestController {
	@Autowired
	StudentBean s1;
	
	@RequestMapping(value = "/getKartItems", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<StudentBean> getItems(HttpServletResponse res, HttpServletRequest req) throws IOException{
		System.out.println("hello world");
		ArrayList<StudentBean> items = new ArrayList<>();
		s1.setStudName("Ramdas");
		
		items.add(s1);
		
		//res.getWriter().write(new Gson().toJson(items));
		String[] itemsString = {s1.toString(), s1.toString()};
		//return new ResponseEntity<StudentBean>(s1, HttpStatus.OK);
		System.out.println("Req Auth type: "+req.getAuthType());
		System.out.println("Req CharacterEncoding "+req.getCharacterEncoding());
		System.out.println("Req ContentLength "+ req.getContentLength());
		System.out.println("Req ContentType "+ req.getContentType());
		System.out.println("Req ContextPath "+ req.getContextPath());
		System.out.println("Req LocalAddr " + req.getLocalAddr());
		System.out.println("Req LocalName "+ req.getLocalName());
		System.out.println("Req LocalPort "+ req.getLocalPort());
		System.out.println("Req Method "+ req.getMethod());
		System.out.println("Req PathInfo "+ req.getPathInfo());
		System.out.println("Req PathTranslated "+ req.getPathTranslated());
		System.out.println("Req Protocol "+ req.getProtocol());
		System.out.println("Req QueryString "+ req.getQueryString());
		System.out.println("Req RemoteAddr "+ req.getRemoteAddr());
		System.out.println("Req RemoteHost "+ req.getRemoteHost());
		System.out.println("Req RemotePort "+ req.getRemotePort());
		System.out.println("Req RemoteUser "+ req.getRemoteUser());
		System.out.println("Req RequestedSessionId "+ req.getRequestedSessionId());
		System.out.println("Req RequestURI "+ req.getRequestURI());
		System.out.println("Req Scheme "+ req.getScheme());
		System.out.println("Req ServerName "+ req.getServerName());
		System.out.println("Req ServerPort "+ req.getServerPort());
		System.out.println("Req ServletPath "+ req.getServletPath());
		/*System.out.println("Req AsyncContext "+ req.getAsyncContext());*/
		System.out.println("Req AttributeNames "+ req.getAttributeNames());
		System.out.println("Req Class "+ req.getClass());
		System.out.println("Req DispatcherType "+ req.getDispatcherType());
		System.out.println("Req HeaderNames "+ req.getHeaderNames());
		System.out.println("Req Locale "+ req.getLocale());
		System.out.println("Req Locales "+ req.getLocales());
		return items;
		
	}
}
