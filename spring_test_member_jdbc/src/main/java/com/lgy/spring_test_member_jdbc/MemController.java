package com.lgy.spring_test_member_jdbc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemController {
	MemService service;
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		log.info("login");
		return "login";
	}
	
	@RequestMapping("/login_process")
	public String login_process(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		
		service = new MemLoginService();
		int result = service.execute(model);
		log.info("@# login_ok result ===>"+result);
		if(result == 1) {
			return "redirect:login_ok";
		}
		return "redirect:login";
	}
	
	@RequestMapping("/login_ok")
	public String login_ok(HttpServletRequest request, Model model) {
		log.info("login_ok");
		return "login_ok";
	}
	
	
	@RequestMapping("/register_jsp")
	public String register_jsp(HttpServletRequest request, Model model) {
		return "register";
	}
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		service = new MWriteService();
		service.execute(model);
		
		return "redirect:login";
	}
}
