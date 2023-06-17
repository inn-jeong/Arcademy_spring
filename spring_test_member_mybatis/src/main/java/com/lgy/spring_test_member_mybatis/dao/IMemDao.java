package com.lgy.spring_test_member_mybatis.dao;

import java.util.ArrayList;

import com.lgy.spring_test_member_mybatis.dto.MemDto;


public interface IMemDao {
	public int memberCheck(String mem_uid, String mem_pwd);
	public ArrayList<MemDto> loginYn(String mem_uid, String mem_pwd);
	public int memberInsert(String mem_uid, String mem_pwd, String mem_name);
}
