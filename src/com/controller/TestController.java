package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.beans.TestBean;

@Controller
public class TestController {
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	protected ModelAndView welcomeController() {
		System.out.println("In controller");

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("headerMsg", "Wel-Come to Shopping Mart");
		return mv;
	}

	@RequestMapping("uploadform")
	public ModelAndView uploadForm() {
		return new ModelAndView("uploadform");
	}

	@RequestMapping(value = "/savefile", method = RequestMethod.POST)
	public ModelAndView saveimage(@RequestParam CommonsMultipartFile file,
			HttpSession session) throws Exception {

		final String UPLOAD_DIRECTORY = "resources/uploaded";
		final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB

		/*DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);*/
		ServletContext context = session.getServletContext();

		String uploadPath = context.getRealPath(UPLOAD_DIRECTORY);
		System.out.println(uploadPath);
		
		byte[] bytes = file.getBytes();
		System.out.println("File name "+ file.getOriginalFilename());
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(uploadPath + File.separator + file.getOriginalFilename())));
		stream.write(bytes);
		stream.flush();
		stream.close();

		return new ModelAndView("uploadform", "filesuccess",
				"File successfully saved!");
	}
	
	@RequestMapping(value="/contextCheck", method=RequestMethod.GET)
	public void webAppCOntextTest(HttpServletRequest req, HttpServletResponse res, ServletContextEvent context){
		WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(context.getServletContext());
		TestBean t1 = (TestBean) wc.getBean("test");
		System.out.println(t1);
	}
	
}
