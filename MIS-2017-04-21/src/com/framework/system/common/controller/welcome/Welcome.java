package com.framework.system.common.controller.welcome;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("/welcome")
@Controller
public class Welcome {
	private static Logger logger = Logger.getLogger(Welcome.class);
	
	@RequestMapping(params = "main")
	public ModelAndView welcome(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/system/welcome");
		return mav;
	}
	
	@RequestMapping(params = "center")
	public ModelAndView center(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/system/welcomeCenter");			
		return mav;
	}
 
}
