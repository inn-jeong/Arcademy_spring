package com.lgy.spring_ex3_8;

public class MyMedian {
	private int num1,num2,num3;
	private Median median;
	
	public void pc() {
		median.process(num1, num2, num3);
	}
	
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public int getNum3() {
		return num3;
	}
	public void setNum3(int num3) {
		this.num3 = num3;
	}
	public Median getMedian() {
		return median;
	}
	public void setMedian(Median median) {
		this.median = median;
	}
	
}
