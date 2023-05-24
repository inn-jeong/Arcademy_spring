package com.lgy.spring_7_3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Student student1 = ctx.getBean("student",Student.class);
		
		//student1 ->student
		System.out.println("이름: "+ student1.getName());
		System.out.println("나이: "+ student1.getAge());
		System.out.println("=========================");
		
		//student2 -> stuent(홍길자)
		Student student2 = ctx.getBean("student",Student.class);
		student2.setName("홍길자");
		student2.setAge(100);
		System.out.println("이름: "+ student2.getName());
		System.out.println("나이: "+ student2.getAge());
		System.out.println("=========================");
		
		//student1 ->student(홍길자)
		System.out.println("이름: "+ student1.getName());
		System.out.println("나이: "+ student1.getAge());
		System.out.println("=========================");
		
		if(student1.equals(student2)) {
			System.out.println("student1 == student2");
		}else {
			System.out.println("student1 != student2");
		}
	}
}
