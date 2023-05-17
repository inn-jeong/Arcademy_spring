package com.lgy.spring_ex2_6;

public class Capital {
	private char ch;

	public char getCh() {
		return ch;
	}

	public void setCh(char ch) {
		this.ch = ch;
	}
	
	public void capital() {
		String str = "";
		for(char i=ch; i>='A'; i--) {
			str = "";
			for(char j='A'; j<=i; j++) {
				str += j;
			}
			System.out.println(str);
		}
	}
}
