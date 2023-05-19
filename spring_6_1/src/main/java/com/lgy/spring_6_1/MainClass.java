package com.lgy.spring_6_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String configLoc1 = "classpath:applicationCTX1.xml";
		String configLoc2 = "classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc1,configLoc2);
		 
		//홍길동 객체 정보 가져옴
		Student student1 = ctx.getBean("student1",Student.class);
		System.out.println(student1.getName());
		System.out.println(student1.getHobbys());
		
		StudentInfo studentInfo = ctx.getBean("studentInfo1", StudentInfo.class);
		//sudent1 객체를 참조
		Student student2 = studentInfo.getStudent();
		//동일한 객체로 출력
		if(student1.equals(student2)) {
			System.out.println("student1 == student2");
		}else {
			System.out.println("student1 != student2");
		}
		System.out.println(student2.getName());
		System.out.println(student2.getHobbys());
		
		//홍길자 객체 정보 가져옴
		Student student3 = ctx.getBean("student3",Student.class);
		System.out.println(student3.getName());
		System.out.println(student3.getHobbys());
		//동일하지 않은 객체
		if(student1.equals(student3)) {
			System.out.println("student1 == student3");
		}else {
			System.out.println("student1 != student3");
		}
		
		Familly familly = ctx.getBean("familly", Familly.class);
		System.out.println(familly.getPapaName());
		System.out.println(familly.getMamiName());
		System.out.println(familly.getBrotherName());
		System.out.println(familly.getSisterName());
		
		ctx.close();
	}
}
