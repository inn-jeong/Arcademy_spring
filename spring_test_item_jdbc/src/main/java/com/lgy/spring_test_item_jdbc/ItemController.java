package com.lgy.spring_test_item_jdbc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ItemController {
	ItemService service;
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("/itemWrite")
	public String insertItem(HttpServletRequest request, Model model) {
		log.info("@# insertItem");
		return "itemWrite";
	}
	
	@RequestMapping("/insert")
	public String item(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		service = new ItemWriteService();
		service.execute(model);
		
		return "itemWrite";
	}
	
	@RequestMapping("/content_view")
	public String list(HttpServletRequest request, Model model) {
		log.debug("@# content");

		service = new ItemContentService();
		service.execute(model);//있으면 가고 없으면 없는대로
		
		return "content_view";
	}
	
	@RequestMapping("/writeResult")
	public String result(HttpServletRequest request, Model model) {
		log.info("@# result");

//		model.addAttribute("request",request);
//		service = new ItemWriteService();
//		service.execute(model);
		
		return "writeResult";
	}
}
