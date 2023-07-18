package com.boot;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemDao {
	public void insertItem(HashMap<String, String> param);
	public ArrayList<ItemDto> list();
}
