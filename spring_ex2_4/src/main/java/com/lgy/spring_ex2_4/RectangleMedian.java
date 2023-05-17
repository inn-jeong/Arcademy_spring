package com.lgy.spring_ex2_4;

public class RectangleMedian {
	public static void main(String[] args) {
		Rectangle rect = new Rectangle();
		rect.setX(150);
		rect.setY(150);
		rect.process();
		
		Median median = new Median();
		median.setNum1(20);
		median.setNum2(100);
		median.setNum3(122);
		median.median();
	}
}
