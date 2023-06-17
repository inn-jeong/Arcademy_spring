package com.lgy.spring_test_member_std;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("MemService")
public class MemServiceImpl implements MemService{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int loginYn(HashMap<String, String> param) {
		IMemDao dao = sqlSession.getMapper(IMemDao.class);
		int re = 0;
		String mem_pwd = param.get("mem_pwd");
		ArrayList<MemDto> dtos = dao.loginYn(param);
		
		if(dtos != null) {//isEmpty() 도 가능
			String db_mem_pwd = dtos.get(0).getMem_pwd();
			log.info("@# service db_mem_uid ===>"+db_mem_pwd);

			if(mem_pwd.equals(db_mem_pwd)) {
				re=1;
			}else {
				re=0;
			}
		}else {
			re=-1;
		}
		return re;
	}

	@Override
	public void memberInsert(HashMap<String, String> param) {
		IMemDao dao = sqlSession.getMapper(IMemDao.class);
		dao.memberInsert(param);
	}

}
