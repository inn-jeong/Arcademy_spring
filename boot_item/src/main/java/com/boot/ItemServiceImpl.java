package com.boot;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemDao dao;
	
	@Override
	public void insertItem(HashMap<String, String> param) {
		dao.insertItem(param);
	}

	@Override
	public ArrayList<ItemDto> list() {
		ArrayList<ItemDto> list = dao.list();
		return list;
	}

}
