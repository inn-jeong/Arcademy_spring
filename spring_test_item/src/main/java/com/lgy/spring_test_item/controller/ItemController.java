package com.lgy.spring_test_item.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.spring_test_item.command.ItemContentService;
import com.lgy.spring_test_item.command.ItemService;
import com.lgy.spring_test_item.command.ItemWriteService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ItemController {
	ItemService service;
	
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
