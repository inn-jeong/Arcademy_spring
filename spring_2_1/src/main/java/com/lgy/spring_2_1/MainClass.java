package com.lgy.spring_2_1;

public class MainClass {
	public static void main(String[] args) {
		//Calculation 클래스가 MainClass 클래스에 의존
		//Calculation 클래스로 객체 생성해서 값을 주입
		Calculation calculation = new Calculation();
		//의존 + 주입(Dependency Injection): DI
		calculation.setFirstNum(10);
		calculation.setSecondNum(2);
		
		calculation.add();
		calculation.sub();
		calculation.mul();
		calculation.div();
		
	}
	
}
