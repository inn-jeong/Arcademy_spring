package com.lgy.spring_test_item_std;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("ItemService")
public class ItemServiceImpl implements ItemService{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertItem(HashMap<String, String> param) {
		ItemDao dao = sqlSession.getMapper(ItemDao.class);
		dao.insertItem(param);
	}

	@Override
	public ArrayList<ItemDto> list() {
		ItemDao dao = sqlSession.getMapper(ItemDao.class);
		ArrayList<ItemDto> list = dao.list();
		return list;
	}

}
