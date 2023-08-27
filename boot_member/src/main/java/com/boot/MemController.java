package com.boot;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemController {
	@Autowired
	private MemService service;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		log.info("login");
		return "login";
	}
	
	@RequestMapping("/login_process")
	public String login_process(@RequestParam HashMap<String, String> param, Model model) {
		log.info("@# login_process start");
		int re = service.loginYn(param);
		String str = "";
		if(re == 1) {
			str = "redirect:login_ok";
		}else {
			str = "redirect:login";
		}
		log.info("@# login_process end");
		return str;
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
	public String register(@RequestParam HashMap<String, String> param, Model model) {
		
		service.memberInsert(param);
		return "redirect:login";
	}
}
