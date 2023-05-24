package com.lgy.spring_ex2_1;

public class Draw {
	public static void main(String[] args) {
		//Circle 클래스가 Draw 클래스에 의존
		//Circle 클래스로 객체 생성해서 값을 주입
		//의존+주입(Dependency Injection) : DI
		Circle circle = new Circle();
		circle.setR(10);
		
		//의존+주입(Dependency Injection) : DI
		Rectangle rect = new Rectangle();
		rect.setWidth(20);
		rect.setHeight(30);
		
		double areaC = circle.areaCircle();
		int areaR = rect.areaRect();
		System.out.println("원의 면적은 "+areaC);
		System.out.println("사각형의 면적은 "+areaR);
	}
}
