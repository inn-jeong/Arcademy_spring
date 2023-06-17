package com.lgy.spring_test_item_jdbc;

import java.util.ArrayList;

import org.springframework.ui.Model;

public class ItemContentService implements ItemService{

	@Override
	public void execute(Model model) {
		ItemDao dao = new ItemDao();
		//게시글을 dtos 객체로 받음
		ArrayList<ItemDto> dtos = dao.list();
		model.addAttribute("list",dtos);
	}

}
