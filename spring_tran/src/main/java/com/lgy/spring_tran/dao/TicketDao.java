package com.lgy.spring_tran.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.lgy.spring_tran.dto.TicketDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TicketDao {
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void buyTicket(final TicketDto dto) {
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				log.info("@# 카드 결제 처리");
				String query = "insert into card(consumerId, amount) values(?,?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, dto.getConsumerId());
				pstmt.setInt(2, dto.getAmount());
				
				return pstmt;
			}
		});
		
		//티켓 수령
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				log.info("@# 카드 결제 처리");
				String query = "insert into ticket(consumerId, countnum) values(?,?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, dto.getConsumerId());
				pstmt.setInt(2, dto.getAmount());
				
				return pstmt;
			}
		});
	}
}