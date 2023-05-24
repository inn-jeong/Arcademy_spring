package com.lgy.spring_ex3_6;

public class MyDivAndRemains {
	private int num;
	private DivAndRemains divAndRemains;
	
	public void pc() {
		divAndRemains.process(num);
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public DivAndRemains getDivAndRemains() {
		return divAndRemains;
	}
	public void setDivAndRemains(DivAndRemains divAndRemains) {
		this.divAndRemains = divAndRemains;
	}
	
}
