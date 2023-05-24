package com.lgy.spring_7_2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean{
	private String name;
	private int age;
	
	//1. 빈 생성시 호출
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("@# afterPropertiesSet()");
	}
	//4. 빈 소멸후 호출
	@Override
	public void destroy() throws Exception {
		System.out.println("@# destroy()");
	}
	
	public Student(String name, int age) {
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
