package com.lgy.spring_7_2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class OtherStudent{
	private String name;
	private int age;
	
	//2. 빈 객체 생성한 후 호출
	@PostConstruct
	public void initMethod() {
		System.out.println("@# initMethod()");
	}
	
	//3.빈이 소멸시 호출
	@PreDestroy
	public void destroyMethod() {
		System.out.println("@# destroyMethod()");
	}
	
	public OtherStudent(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	
}
