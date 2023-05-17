package com.lgy.spring_ex2_4;

public class Rectangle {
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void process() {
		if(x >= 100 && x <= 200 && y >= 100 && y <= 200) {
			System.out.println("("+x+","+y+") 는 사각형 안에 있습니다.");
		}else {
			System.out.println("("+x+","+y+") 는 사각형 안에 없습니다.");
		}
	}
}
