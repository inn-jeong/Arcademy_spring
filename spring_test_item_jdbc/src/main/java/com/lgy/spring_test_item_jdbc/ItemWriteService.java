package com.lgy.spring_test_item_jdbc;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemWriteService implements ItemService{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		log.info("@# des ===>"+description);
		
		ItemDao dao = new ItemDao();
		dao.insertItem(name, price, description);
	}

}
