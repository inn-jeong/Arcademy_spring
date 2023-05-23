package com.lgy.spring_6_4;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//스프링 설정파일로 설정
@Configuration
@ImportResource("classpath:applicationCTX.xml")
public class ApplicationConfig {
	@Bean(name = "name")
	public Student student1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("요리");
		
		Student student = new Student("홍길동", 20, hobbys);
		student.setHeight(180);
		student.setWeight(80);
		
		return student;
	}
//	@Bean
//	public StudentInfo studentInfo() {
//		ArrayList<String> hobbys = new ArrayList<String>();
//		hobbys.add("수영");
//		hobbys.add("요리");
//		
//		Student student = new Student("홍길동", 20, hobbys);
//		student.setHeight(180);
//		student.setWeight(80);
//		
//		StudentInfo studentInfo = new StudentInfo();
//		studentInfo.setStudent(student);
//		return studentInfo;
//	}
//	@Bean
//	public Student student2() {
//		ArrayList<String> hobbys = new ArrayList<String>();
//		hobbys.add("독서");
//		hobbys.add("음악감상");
//		
//		Student student = new Student("홍길순", 18, hobbys);
//		student.setHeight(170);
//		student.setWeight(55);
//		
//		return student;
//	}
}
