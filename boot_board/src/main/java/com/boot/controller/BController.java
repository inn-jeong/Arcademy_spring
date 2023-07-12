package com.boot.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boot.dto.BDto;
import com.boot.service.BService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BController {
	
	@Autowired
	private BService service;
	
	@RequestMapping("/list")
	public String list(Model model) {
		log.info("@# list start");
		
		ArrayList<BDto> list = service.list();
		model.addAttribute("list",list);
		
		log.info("@# list end");
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		log.info("@# write_view");
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(@RequestParam HashMap<String, String> param) {
		log.info("@# write");
		
		service.write(param);
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(@RequestParam HashMap<String, String> param, Model model) {
		log.info("@# content_view start");
		
		model.addAttribute("content_view",service.contentView(param));
		model.addAttribute("pageMaker",param);
		
		log.info("@# content_view end");
		return "content_view";
	}
	
	@RequestMapping("/modify")
	public String modify(@RequestParam HashMap<String, String> param, RedirectAttributes rttr) {
		log.info("@# modify");
		
		service.modify(param);
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam HashMap<String, String> param, RedirectAttributes rttr) {
		log.info("@# delete");
		
		service.delete(param);
		return "redirect:list";
	}
}
