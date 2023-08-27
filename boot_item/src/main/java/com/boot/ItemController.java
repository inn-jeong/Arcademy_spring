package com.boot;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	@RequestMapping("/itemWrite")
	public String insertItem() {
		log.info("@# insertItem");
		return "itemWrite";
	}
	
	@RequestMapping("/insert")
	public String item(@RequestParam HashMap<String, String> param) {
		service.insertItem(param);
		
		return "itemWrite";
	}
	
	@RequestMapping("/content_view")
	public String list(Model model) {
		log.debug("@# content");

		model.addAttribute("list",service.list());
		
		return "content_view";
	}
	
	@RequestMapping("/writeResult")
	public String result() {
		log.info("@# result");

		return "writeResult";
	}
}
