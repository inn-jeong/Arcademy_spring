package com.lgy.spring_ex2_5;

public class Multiple {
	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public void multiple() {
		boolean multiple=false;
		if(num%3==0 && num!=0) {
			multiple=true;
			System.out.println("3의 배수이다");
		}
		if(num%5==0 && num!=0) {
			multiple=true;
			System.out.println("5의 배수이다");
		}
		if(num%8==0 && num!=0) {
			multiple=true;
			System.out.println("8의 배수이다");
		}
		if(!multiple) {
			System.out.println("어느 배수도 아니다");
		}
	}
}
