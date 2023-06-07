package com.lgy.spring_test_item.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lgy.spring_test_item.dto.ItemDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemDao {
	DataSource dataSource;
	
	public ItemDao() {
		//dbcp 방식으로 oracle 연결
		try {
			Context context = new InitialContext();
			//context.xml 에 설정(server.xml과 달리 한번 설정으로 모든 프로젝트에서 사용 가능)
			//datasource : CRUD 쿼리에 모두 사용 가능
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//상품 추가
	public void insertItem(String name, String price, String description) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		log.info("@# insert");
		try {
			conn = dataSource.getConnection();
			String sql = "insert into item(name, price, description) "
					+ "values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, Integer.parseInt(price));
			pstmt.setString(3, description);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	//상품리스트
	public ArrayList<ItemDto> list(){
		ArrayList<ItemDto> dtos = new ArrayList<ItemDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "select name,price,description from item";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				String price = ""+rs.getInt("price");
				String description = rs.getString("description");
				ItemDto dto = new ItemDto(name, price, description);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
}
