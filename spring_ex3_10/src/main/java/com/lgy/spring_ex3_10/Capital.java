package com.lgy.spring_ex3_10;

public class Capital {
	public void alphabet(char alpha) {
		for(char i=alpha; i>='A'; i--) {
			for(char j='A'; j<=i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
}
