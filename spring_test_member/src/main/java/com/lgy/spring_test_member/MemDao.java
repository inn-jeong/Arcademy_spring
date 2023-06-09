package com.lgy.spring_test_member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemDao {
	DataSource dataSource;
	
	public MemDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int memberCheck(String mem_uid, String mem_pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		
		try {
			conn = dataSource.getConnection();
			String sql = "select mem_uid, mem_pwd, mem_name from mvc_member where mem_uid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_uid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
//				String db_mem_uid = rs.getString("mem_uid");
				String db_mem_pwd = rs.getString("mem_pwd");
				log.info("@# dao db_mem_uid ===>"+db_mem_pwd);

				if(mem_pwd.equals(db_mem_pwd)) {
					result = 1;
				} else {
					result = 0; 
				}
			}else {
				result = -1;
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
		return result;
	}
}
