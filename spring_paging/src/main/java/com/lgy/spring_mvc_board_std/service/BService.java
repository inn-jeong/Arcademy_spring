package com.lgy.spring_mvc_board_std.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.ui.Model;

import com.lgy.spring_mvc_board_std.dto.BDto;
import com.lgy.spring_mvc_board_std.dto.Criteria;

public interface BService {
	public ArrayList<BDto> list();
	//페이징 처리하는 서비스
	public ArrayList<BDto> list(Criteria cri);
	public void write(HashMap<String, String> param);
	public BDto contentView(HashMap<String, String> param);
	public void modify(HashMap<String, String> param);
	public void delete(HashMap<String, String> param);
	public int getTotalCount();
}
