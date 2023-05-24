package com.lgy.spring_ex3_8;

public class Median {
	public void process(int num1, int num2, int num3) {
		if(num1 > num2 && num1 < num3 || num1 > num3 && num1 < num2) {
			System.out.printf("입력된 정수가 %d와 %d와 %d의 중간값은 %d\n",num1,num2,num3,num1);
		}else if(num2 > num1 && num2 < num3 || num2 > num3 && num2 < num1) {
			System.out.printf("입력된 정수가 %d와 %d와 %d의 중간값은 %d\n",num1,num2,num3,num2);
		}else if(num3 > num1 && num3 < num2 || num3 > num2 && num3 < num1) {
			System.out.printf("입력된 정수가 %d와 %d와 %d의 중간값은 %d\n",num1,num2,num3,num3);
		}
	}
}
