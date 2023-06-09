package com.lgy.spring_mvc_board_jdbc.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.spring_mvc_board_jdbc.dao.*;
import com.lgy.spring_mvc_board_jdbc.dto.*;

public class BContentService implements BService{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bid = request.getParameter("bid");

		BDao dao = new BDao();
		BDto dto = dao.contentView(bid);
		model.addAttribute("content_view", dto);
	}
}
