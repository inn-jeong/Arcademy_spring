package com.lgy.spring_ex2_2;

public class SeasonDollar {
	public static void main(String[] args) {
		Season season = new Season();
		season.setMonth(9);
		
		Won2dollar won2dollar = new Won2dollar();
		won2dollar.setWon(3300);
		
		System.out.println(season.month());
		System.out.println("$"+won2dollar.won2dol());
	}
}
