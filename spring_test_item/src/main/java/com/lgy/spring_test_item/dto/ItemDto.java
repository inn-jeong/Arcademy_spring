package com.lgy.spring_test_item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemDto {
	private String name;
	private String price;
	private String description;
}
