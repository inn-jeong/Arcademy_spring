package com.lgy.spring_test_item_mybatis.dao;

import java.util.ArrayList;

import com.lgy.spring_test_item_mybatis.dto.ItemDto;

public interface ItemDao {
	public void insertItem(String name, String price, String description);
	public ArrayList<ItemDto> list();
}
