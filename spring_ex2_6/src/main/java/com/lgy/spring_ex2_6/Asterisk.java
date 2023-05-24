package com.lgy.spring_ex2_6;

public class Asterisk {
	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public void asterisk() {
		String str = "";
		for(int i=0; i<num; i++) {
			str = "";
			for(int j=5; j>i; j--) {
				str += "*";
			}
			System.out.println(str);
		}
	}
}
