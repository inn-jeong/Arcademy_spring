package com.lgy.spring_mvc_board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.spring_mvc_board.command.BCommand;
import com.lgy.spring_mvc_board.command.BContentCommand;
import com.lgy.spring_mvc_board.command.BDeleteCommand;
import com.lgy.spring_mvc_board.command.BListCommand;
import com.lgy.spring_mvc_board.command.BModifyCommand;
import com.lgy.spring_mvc_board.command.BWriteCommand;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BController {
	BCommand command;
	//게시판 목록 조회
	@RequestMapping("/list")
	public String list(Model model) {
		log.debug("@# list");
		
		//service(command)단 호출
		command = new BListCommand();
		command.execute(model);//있으면 가고 없으면 없는대로
		
		return "list";
	}
	
//	request: 뷰에서 값을 받아옴
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		log.debug("@# write");
		//request 에 bname,btitle,bcontent 값들이 있음
		model.addAttribute("request",request);
		//command 단 호출
		command = new BWriteCommand();
		//model에 request 를 담고 있음
		command.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		log.debug("@# write_view");
		return "write_view";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		log.debug("@# content_view");
		
		model.addAttribute("request",request);
		command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		log.debug("@# modify");
		
		model.addAttribute("request",request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		log.debug("@# delete");
		
		model.addAttribute("request",request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
}
