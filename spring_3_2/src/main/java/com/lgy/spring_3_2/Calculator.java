package com.lgy.spring_3_2;

public class Calculator {
	public void addtion(int f, int s) {
		System.out.println("addtion()");
		int result = f+s;
		System.out.println(f+"+"+s+"="+result);
	}
	public void subtraction(int f, int s) {
		System.out.println("substraction()");
		int result = f-s;
		System.out.println(f+"-"+s+"="+result);
	}
	public void multiplication(int f, int s) {
		System.out.println("multiplacatoin()");
		int result = f*s;
		System.out.println(f+"*"+s+"="+result);
	}
	public void division(int f, int s) {
		System.out.println("division()");
		int result = f/s;
		System.out.println(f+"/"+s+"="+result);
	}
	
}
