package com.lgy.spring_ex3_2;

public class MyRectangle {
	private int width, height;
	private Rectangle rectangle;
	
	public void ar() {
		rectangle.area(width, height);
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Rectangle getRectangle() {
		return rectangle;
	}
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
}
