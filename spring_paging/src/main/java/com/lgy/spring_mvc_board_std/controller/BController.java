package com.lgy.spring_mvc_board_std.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lgy.spring_mvc_board_std.dto.BDto;
import com.lgy.spring_mvc_board_std.dto.Criteria;
import com.lgy.spring_mvc_board_std.dto.PageDto;
import com.lgy.spring_mvc_board_std.service.BService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BController {
	
	@Autowired
	private BService service;
	
	@RequestMapping("/list")
	public String list(Criteria cri, Model model) {
		log.info("@# list start");
		log.info("@# rio");
		int total = service.getTotalCount();
		model.addAttribute("list",service.list(cri));
		model.addAttribute("pageMaker",new PageDto(total, cri));
		
		log.info("@# list end");
		return "list";
	}
	
	@RequestMapping("/list_old")
	public String list(Model model) {
		log.info("@# list start");
		
		ArrayList<BDto> list = service.list();
		model.addAttribute("list",list);
		
		log.info("@# list end");
		return "list";
	}
	
	@RequestMapping("/write")
	public String write(@RequestParam HashMap<String, String> param) {
		log.info("@# write start");
		
		service.write(param);
		
		log.info("@# write end");
		return "redirect:list";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		log.info("@# write_view");
		return "write_view";
	}
	
	@RequestMapping("/content_view")
	public String content_view(@RequestParam HashMap<String, String> param, Model model) {
		log.info("@# content_view start");
		
		model.addAttribute("content_view",service.contentView(param));
		model.addAttribute("pageMaker",param);
		
		log.info("@# content_view end");
		return "content_view";
	}
	
//	@ModelAttribute("cri") Criteria cri: Criteria 객체를 cri 로 받는다
//	RedirectAttribute rttr : 쿼리 스트링 뒤에 추가
	@RequestMapping("/modify")
	public String modify(@RequestParam HashMap<String, String> param, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("@# modify start");
		
		service.modify(param);
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		
		log.info("@# modify end");
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam HashMap<String, String> param, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("@# delete start");
		
		service.delete(param);
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		
		log.info("@# delete end");
		return "redirect:list";
	}
}
