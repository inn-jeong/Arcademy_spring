package com.lgy.spring_mvc_board_jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.lgy.spring_mvc_board_jdbc.dto.BDto;
import com.lgy.spring_mvc_board_jdbc.util.Constant;

import lombok.extern.slf4j.Slf4j;

//DB SQL 처리
@Slf4j
public class BDao {
	JdbcTemplate template = null;
	
	public BDao() {
		//dbcp 방식으로 oracle 연결
		//Constant.template 에서 가져옴
		template = Constant.template;
	}
	
	//게시판 목록 조회
	public ArrayList<BDto> list(){
		//1. 35줄 -> 4줄
//		ArrayList<BDto> dtos = null;
//		String sql = "select bid, bname, btitle, bcontent, bdate, bhit from mvc_board";
//		dtos = (ArrayList<BDto>) template.query(sql, new BeanPropertyRowMapper(BDto.class));
//		return dtos;

		//2번 2줄
//		String sql = "select bid, bname, btitle, bcontent, bdate, bhit from mvc_board";
//		return (ArrayList<BDto>) template.query(sql, new BeanPropertyRowMapper(BDto.class));
		
		//3번 1줄
		return (ArrayList<BDto>) template.query("select bid, bname, btitle, bcontent, bdate, bhit from mvc_board", new BeanPropertyRowMapper(BDto.class));
	}
	
	public void write(final String bname, final String btitle, final String bcontent) {
		//22줄 -> 15 ?
		//update: jdbc template 으로 insert(PreparedStatementCreator 객체 사용)
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "insert into mvc_board(bid, bname, btitle, bcontent, bhit) "
						+ "values(MVC_BOARD_SEQ.NEXTVAL,?,?,?,0)";
				//con : 메소드 매개변수와 이름 일치
				PreparedStatement pstmt = con.prepareStatement(sql);
				//bname 파라미터 등은 final로 구성
				pstmt.setString(1, bname);
				pstmt.setString(2, btitle);
				pstmt.setString(3, bcontent);
				
				return pstmt;
			}
		});
	}

	
	//게시글 하나를 리턴하기 위해서 BDto 사용(strID: 글번호)
	public BDto contentView(String strID) {
		//35줄 -> 4줄 
		upHit(strID);
		String sql = "select bid, bname, btitle, bcontent, bdate, bhit "
				+ "from mvc_board where bid="+strID;
		//queryForObject : jdbc 템플릿 조회 처리
		return template.queryForObject(sql, new BeanPropertyRowMapper<BDto>(BDto.class));
		
	}
	
	//게시글 조회수 올리기
	private void upHit(final String bid) {
		//18줄 -> 7줄 
		String sql = "update mvc_board set bhit = bhit+1 where bid=?";
		//update: sql update (PreparedStatementSetter 객체 사용)
		template.update(sql,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(bid));
			}
		});
	}
	
	//게시글 수정
	public void modify(final String bid, final String bname, final String btitle, final String bcontent) {
		//25줄 ->10줄
		String sql = "update mvc_board set bname=?, btitle=?, bcontent=? where bid=?";
		template.update(sql,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bname);
				ps.setString(2, btitle);
				ps.setString(3, bcontent);
				ps.setInt(4, Integer.parseInt(bid));
			}
		});
	}
	
	//게시글 삭제
	public void delete(final String strID) {
		//28줄 -> 7줄
		String sql = "delete from mvc_board where bid=?";
		//update : jdbc template 삭제 처리
		template.update(sql,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(strID));
			}
		});
	}
}
