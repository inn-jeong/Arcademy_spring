package com.boot.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.IBDao;
import com.boot.dto.BDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BServiceImpl implements BService{
	@Autowired
	private IBDao dao;
	
	@Override
	public ArrayList<BDto> list() {
		log.info("@# BServiceImpl.list()");
		
		ArrayList<BDto> list = dao.list();
		
		return list;
	}
	
	@Override
	public void write(HashMap<String, String> param) {
		log.info("@# BServiceImpl.write()");
		
		dao.write(param);		
	}
	
	@Override
	public BDto contentView(HashMap<String, String> param) {
		log.info("@# BServiceImpl.contentView()");
		
		BDto dto = dao.contentView(param);
		return dto;
	}
	
	@Override
	public void modify(HashMap<String, String> param) {
		log.info("@# BServiceImp.modify()");
		
		dao.modify(param);
	}

	@Override
	public void delete(HashMap<String, String> param) {
		log.info("@# BServiceImp.delete()");
		
		dao.delete(param);
	}
}
