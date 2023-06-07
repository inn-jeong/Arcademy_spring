package com.lgy.spring_test_item.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.spring_test_item.dao.ItemDao;
import com.lgy.spring_test_item.dto.ItemDto;

public class ItemContentService implements ItemService{

	@Override
	public void execute(Model model) {
		ItemDao dao = new ItemDao();
		//게시글을 dtos 객체로 받음
		ArrayList<ItemDto> dtos = dao.list();
		model.addAttribute("list",dtos);
	}
}
