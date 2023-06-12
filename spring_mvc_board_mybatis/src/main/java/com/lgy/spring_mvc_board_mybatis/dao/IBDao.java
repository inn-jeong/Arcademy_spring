package com.lgy.spring_mvc_board_mybatis.dao;

import java.util.ArrayList;

import com.lgy.spring_mvc_board_mybatis.dto.BDto;


public interface IBDao {
	public ArrayList<BDto> list();
	public void write(String bname, String btitle, String bcontent);
	public BDto contentView(String strID);
//	private void upHit(String bid);
	public void modify(String bid, String bname, String btitle, String bcontent);
	public void delete(String strID);
}
