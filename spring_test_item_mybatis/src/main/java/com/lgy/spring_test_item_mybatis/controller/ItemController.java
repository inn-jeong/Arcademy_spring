package com.lgy.spring_test_item_mybatis.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.spring_test_item_mybatis.dao.ItemDao;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ItemController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/itemWrite")
	public String insertItem(HttpServletRequest request, Model model) {
		log.info("@# insertItem");
		return "itemWrite";
	}
	
	@RequestMapping("/insert")
	public String item(HttpServletRequest request, Model model) {
		ItemDao dao = sqlSession.getMapper(ItemDao.class);
		dao.insertItem(request.getParameter("name")
					, request.getParameter("price")
					, request.getParameter("description")
					);
		
		return "itemWrite";
	}
	
	@RequestMapping("/content_view")
	public String list(HttpServletRequest request, Model model) {
		log.debug("@# content");

		ItemDao dao = sqlSession.getMapper(ItemDao.class);
		model.addAttribute("list",dao.list());
		
		return "content_view";
	}
	
	@RequestMapping("/writeResult")
	public String result(HttpServletRequest request, Model model) {
		log.info("@# result");

		return "writeResult";
	}
}
