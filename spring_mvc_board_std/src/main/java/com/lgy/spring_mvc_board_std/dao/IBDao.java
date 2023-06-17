package com.lgy.spring_mvc_board_std.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.lgy.spring_mvc_board_std.dto.BDto;


public interface IBDao {
	public ArrayList<BDto> list();
//	public void write(String bname, String btitle, String bcontent);
	public void write(HashMap<String, String> param);
//	public BDto contentView(String strID);
	public BDto contentView(HashMap<String, String> param);
//	private void upHit(String bid);
//	public void modify(String bid, String bname, String btitle, String bcontent);
	public void modify(HashMap<String, String> param);
//	public void delete(String strID);
	public void delete(HashMap<String, String> param);
}
