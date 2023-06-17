package com.lgy.spring_test_member_jdbc;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MWriteService implements MemService{

	@Override
	public int execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String mem_uid = request.getParameter("mem_uid");
		String mem_pwd = request.getParameter("mem_pwd");
		String mem_name = request.getParameter("mem_name");
		
		MemDao dao = new MemDao();
		dao.memberInsert(mem_uid, mem_pwd, mem_name);
		return 0;
	}

}
