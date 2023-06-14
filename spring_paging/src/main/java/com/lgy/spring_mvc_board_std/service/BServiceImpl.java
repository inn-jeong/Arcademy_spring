package com.lgy.spring_mvc_board_std.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgy.spring_mvc_board_std.dao.IBDao;
import com.lgy.spring_mvc_board_std.dto.BDto;
import com.lgy.spring_mvc_board_std.dto.Criteria;

import lombok.extern.slf4j.Slf4j;

@Service("BService")
@Slf4j
public class BServiceImpl implements BService{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<BDto> list() {
		log.info("@# BServiceImpl.list() start");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		ArrayList<BDto> list = dao.list();
		
		log.info("@# BServiceImpl.list() end");
		return list;
	}

	@Override
	public ArrayList<BDto> list(Criteria cri) {
		log.info("@# BServiceImpl.list() start");
		log.info("@# cri ===>"+cri);
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		
		log.info("@# BServiceImpl.list(Criteria cri) end");
		return dao.listWithPaging(cri);
	}
	
	@Override
	public void write(HashMap<String, String> param) {
		log.info("@# BServiceImpl.write() start");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.write(param);		
		
		log.info("@# BServiceImpl.write() end");
	}

	@Override
	public BDto contentView(HashMap<String, String> param) {
		log.info("@# BServiceImpl.contentView() start");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		BDto dto = dao.contentView(param);
		
		log.info("@# BServiceImpl.contentView() end");
		return dto;
	}

	@Override
	public void modify(HashMap<String, String> param) {
		log.info("@# BServiceImp.modify() start");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.modify(param);
		
		log.info("@# BServiceImp.modify() end");
	}

	@Override
	public void delete(HashMap<String, String> param) {
		log.info("@# BServiceImp.delete() start");
		
		IBDao dao = sqlSession.getMapper(IBDao.class);
		dao.delete(param);
		
		log.info("@# BServiceImp.delete() end");
	}


}
