package com.boot.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.boot.dto.BDto;

public interface BService {
	public ArrayList<BDto> list();
	public void write(HashMap<String, String> param);
	public BDto contentView(HashMap<String, String> param);
	public void modify(HashMap<String, String> param);
	public void delete(HashMap<String, String> param);
}
