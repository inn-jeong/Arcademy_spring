package com.lgy.spring_test_member_mybatis.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.spring_test_member_mybatis.dao.IMemDao;
import com.lgy.spring_test_member_mybatis.dto.MemDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemController {
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		log.info("login");
		return "login";
	}
	
	@RequestMapping("/login_process")
	public String login_process(HttpServletRequest request, Model model) {
		
		IMemDao dao = sqlSession.getMapper(IMemDao.class);
		String str = "";
		String mem_pwd = request.getParameter("mem_pwd");
		ArrayList<MemDto> dtos = dao.loginYn(request.getParameter("mem_uid")
											, mem_pwd);
		if(dtos != null) {//isEmpty() 도 가능
			String db_mem_pwd = dtos.get(0).getMem_pwd();
			log.info("@# service db_mem_uid ===>"+db_mem_pwd);

			if(mem_pwd.equals(db_mem_pwd)) {
				str = "redirect:login_ok";
			}else {
				str = "redirect:login";
			}
		}else {
			str = "redirect:login";
		}
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
	public String register(HttpServletRequest request, Model model) {
		
		IMemDao dao = sqlSession.getMapper(IMemDao.class);
		dao.memberInsert(request.getParameter("mem_uid")
						, request.getParameter("mem_pwd")
						, request.getParameter("mem_name"));
		
		return "redirect:login";
	}
}
