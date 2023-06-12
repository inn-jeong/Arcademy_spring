package com.lgy.spring_test_member_jdbc;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MemLoginService implements MemService{

	@Override
	public int execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String mem_uid = request.getParameter("mem_uid");
		String mem_pwd = request.getParameter("mem_pwd");
		log.info("@# service mem_uid ===>"+mem_uid);
		int result = 0;
		MemDao dao = new MemDao();
		ArrayList<MemDto> dtos = dao.loginYn(mem_uid,mem_pwd);
		
		if(dtos != null) {//isEmpty() 도 가능
			String db_mem_pwd = dtos.get(0).getMem_pwd();
			log.info("@# service db_mem_uid ===>"+db_mem_pwd);

			if(mem_pwd.equals(db_mem_pwd)) {
				result = 1;
			} else {
				result = 0; 
			}
		}else {
			result = -1;
		}
//		MemDao dao = new MemDao();
//		int result= dao.memberCheck(mem_uid, mem_pwd);
		return result;
	}

}
