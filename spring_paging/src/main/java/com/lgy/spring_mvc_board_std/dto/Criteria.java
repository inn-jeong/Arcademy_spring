package com.lgy.spring_mvc_board_std.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Criteria {
	private int pageNum;
	private int amount;
	public Criteria() {
		//초기 페이지는 1이고, 10개씩 출력
		this(1,10);
	}
}
