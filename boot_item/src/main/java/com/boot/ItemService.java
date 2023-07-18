package com.boot;

import java.util.ArrayList;
import java.util.HashMap;

public interface ItemService {
	public void insertItem(HashMap<String, String> param);
	public ArrayList<ItemDto> list();
}
