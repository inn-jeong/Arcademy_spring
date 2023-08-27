package com.boot.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.boot.dto.BDto;

//실행시 인터페이스에서 매퍼파일을 읽어 들이도록 지정
@Mapper
public interface IBDao {
	public ArrayList<BDto> list();
	public void write(HashMap<String, String> param);
	public BDto contentView(HashMap<String, String> param);
//	private void upHit(String bid);
	public void modify(HashMap<String, String> param);
	public void delete(HashMap<String, String> param);
}
