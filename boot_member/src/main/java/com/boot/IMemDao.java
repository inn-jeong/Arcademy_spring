package com.boot;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMemDao {
	public ArrayList<MemDto> loginYn(HashMap<String, String> param);
	public void memberInsert(HashMap<String, String> param);
}
