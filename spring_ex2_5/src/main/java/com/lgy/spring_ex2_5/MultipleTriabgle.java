package com.lgy.spring_ex2_5;

public class MultipleTriabgle {
	public static void main(String[] args) {
		Multiple multiple = new Multiple();
		multiple.setNum(240);
		multiple.multiple();
		
		Triangle triangle = new Triangle();
		triangle.setNum1(4);
		triangle.setNum2(3);
		triangle.setNum3(5);
		triangle.tri();
	}
}
