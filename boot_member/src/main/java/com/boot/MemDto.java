package com.boot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemDto {
	private String mem_uid;
	private String mem_pwd;
	private String mem_name;
}
