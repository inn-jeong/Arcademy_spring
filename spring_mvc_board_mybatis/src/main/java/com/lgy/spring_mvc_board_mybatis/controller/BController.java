package com.lgy.spring_mvc_board_mybatis.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.spring_mvc_board_mybatis.dao.IBDao;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BController {
	
	//servlet-context 에 있는 sqlsession 객체 연결
	@Autowired
	private SqlSession sqlSession;
	
	//게시판 목록 조회
	@RequestMapping("/list")
	public String list(Model model) {
		log.info("@# list");
		
		//getMapper: dao로 연결
		IBDao dao = sqlSession.getMapper(IBDao.class);
		//서비스단에서 처리했던 것을 컨트롤러 단에서 처리
		model.addAttribute("list",dao.list());
		
		return "list";
	}
	
//	request: 뷰에서 값을 받아옴
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		log.info("@# write");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		//서비스단에서 처리했던 것을 컨트롤러 단에서 처리
		dao.write(request.getParameter("bname")
				, request.getParameter("btitle")
				, request.getParameter("bcontent"));
		
		return "redirect:list";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		log.info("@# write_view");
		return "write_view";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		log.info("@# content_view");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		//서비스단에서 처리했던 것을 컨트롤러 단에서 처리
		model.addAttribute("content_view",dao.contentView(request.getParameter("bid")));
		
		return "content_view";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		log.info("@# modify");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		//서비스단에서 처리했던 것을 컨트롤러 단에서 처리
		dao.modify(request.getParameter("bid")
				, request.getParameter("bname")
				, request.getParameter("btitle")
				, request.getParameter("bcontent"));
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		log.info("@# delete");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		//서비스단에서 처리했던 것을 컨트롤러 단에서 처리
		dao.delete(request.getParameter("bid"));
		
		return "redirect:list";
	}
}
