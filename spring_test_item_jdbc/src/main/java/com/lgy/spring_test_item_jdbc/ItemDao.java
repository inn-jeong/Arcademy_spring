package com.lgy.spring_test_item_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;



public class ItemDao {
	JdbcTemplate template = null;
	
	public ItemDao() {
		template = Constant.template;
	}
	
	//상품 추가
	public void insertItem(final String name, final String price, final String description) {
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "insert into item(name, price, description) "
						+ "values(?,?,?)";
				//con : 메소드 매개변수와 이름 일치
				PreparedStatement pstmt = con.prepareStatement(sql);
				//bname 파라미터 등은 final로 구성
				pstmt.setString(1, name);
				pstmt.setString(2, price);
				pstmt.setString(3, description);
				
				return pstmt;
			}
		});
	}
	
	//상품리스트
	public ArrayList<ItemDto> list(){
		return (ArrayList<ItemDto>) template.query("select name,price,description from item", new BeanPropertyRowMapper(ItemDto.class));
	}
}
