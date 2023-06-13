package com.lgy.spring_test_item_std;

import java.util.ArrayList;
import java.util.HashMap;

public interface ItemService {
	public void insertItem(HashMap<String, String> param);
	public ArrayList<ItemDto> list();
}
