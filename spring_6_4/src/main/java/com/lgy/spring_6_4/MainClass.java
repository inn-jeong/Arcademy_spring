package com.lgy.spring_6_4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		//클래스로 자바 스프링 설정파일 정보 가져옴
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		//xml스프링 설정으로 변경
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		//객체 정보 가져옴
//		Student student = ctx.getBean("student1", Student.class);
		Student student = ctx.getBean("name", Student.class);
		System.out.println("이름: "+student.getName());
		System.out.println("나이: "+student.getAge());
		System.out.println("취미: "+student.getHobbys());
		System.out.println("신장: "+student.getHeight());
		System.out.println("몸무게: "+student.getWeight());
		
		//홍길순 객체정보 가져옴
//		Student student2 = ctx.getBean("student2", Student.class);
//		System.out.println("이름: "+student2.getName());
//		System.out.println("나이: "+student2.getAge());
//		System.out.println("취미: "+student2.getHobbys());
//		System.out.println("신장: "+student2.getHeight());
//		System.out.println("몸무게: "+student2.getWeight());
	}
}
