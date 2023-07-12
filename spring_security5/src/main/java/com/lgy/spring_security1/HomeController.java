package com.lgy.spring_security1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

//	security:intercept-url pattern="/login.html*" 대상이 됨
	@RequestMapping("login.html")
	public String login() {
		return "security/login";
	}
	
//	@RequestMapping("/welcome.html") => 로긴되면 @RequestMapping(value = "/" 이동
	@RequestMapping("welcome.html")
	public String welcome() {
		return "security/welcome";
	}
	
	@RequestMapping("loginForm.html")
	public String loginForm() {
		return "security/loginForm";
	}
}














