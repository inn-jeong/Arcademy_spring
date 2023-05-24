package com.lgy.spring_ex3_7;

public class MyRectangle {
	private int x,y;
	private Rectangle rectangle;
	
	public void pc() {
		rectangle.process(x, y);
	}
	
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
	public Rectangle getRectangle() {
		return rectangle;
	}
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
}
