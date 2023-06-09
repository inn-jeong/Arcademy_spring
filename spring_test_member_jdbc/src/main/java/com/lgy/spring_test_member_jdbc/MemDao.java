package com.lgy.spring_test_member_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemDao {
	JdbcTemplate template = null;
	
	public MemDao() {
		template = Constant.template;
	}
	
	public int memberCheck(String mem_uid, String mem_pwd) {
		ResultSetExtractor<ResultSet> rse= null;
		int result = -1;
		MemDto dto = template.queryForObject("select mem_uid, mem_pwd, mem_name from mvc_member where mem_uid='"+mem_uid+"'", new BeanPropertyRowMapper<MemDto>(MemDto.class));
		
		if(dto.getMem_uid() != null) {
			String db_mem_pwd = dto.getMem_pwd();
			log.info("@# dao db_mem_uid ===>"+db_mem_pwd);

			if(mem_pwd.equals(db_mem_pwd)) {
				result = 1;
			} else {
				result = 0; 
			}
		}else {
			result = -1;
		}
		return result;
	}
	
	public int memberInsert(final String mem_uid, final String mem_pwd, final String mem_name) {
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "insert into mvc_member(mem_uid, mem_pwd, mem_name) "
						+ "values(?,?,?)";
				//con : 메소드 매개변수와 이름 일치
				PreparedStatement pstmt = con.prepareStatement(sql);
				//bname 파라미터 등은 final로 구성
				pstmt.setString(1, mem_uid);
				pstmt.setString(2, mem_pwd);
				pstmt.setString(3, mem_name);
				
				return pstmt;
			}
		});
		
		return 0;
	}
}
