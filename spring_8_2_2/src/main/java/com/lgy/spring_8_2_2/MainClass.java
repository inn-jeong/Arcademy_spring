package com.lgy.spring_8_2_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationCTX.xml");
//		스프링 자바 설정파일 사용
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	
		AdminConnection connection = ctx.getBean("adminConnection",AdminConnection.class);
		
		System.out.println("adminID: "+connection.getAdminID());
		System.out.println("adminPW: "+connection.getAdminPW());
		System.out.println("sub_adminID: "+connection.getSub_adminID());
		System.out.println("sub_adminPW: "+connection.getSub_adminPW());
	}
}
