package com.lgy.spring_mvc_board_std.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDto {
	//페이지 번호가 10개씩 보이게 (1~10, 11~20)
	private int startPage; //시작페이지: 1,11
	private int endPage; //끝페이지: 10,20
	private boolean prev,next;
	private int total;
	private Criteria cri; //화면에 출력 개수
	
	public PageDto(int total, Criteria cri) {
		this.total = total;
		this.cri = cri;
		
		//ex>3페이지=3/10->0.3 -> 1*10 = 10 (끝페이지)
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		
		//ex> 10-9=1페이지
		this.startPage = this.endPage-9;
		
		//ex>total: 70, 현재 페이지: 3 -> endPage: 10 => 70*1.0 / 10 => 7페이지
		int realEnd = (int)(Math.ceil((total * 1.0) / cri.getAmount()));
		
		if(realEnd <= this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
