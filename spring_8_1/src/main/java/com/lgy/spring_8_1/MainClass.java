package com.lgy.spring_8_1;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		//ConfigurableApplicationContext 인터페이스 이용해서 Environment 객체 생성
		ConfigurableEnvironment env = ctx.getEnvironment();
		//getPropertySources() 를 이용해서 프로퍼티 소시 객체 생성
		MutablePropertySources propertySources = env.getPropertySources();
		//ResourcePropertySource 객체를 이용해서 외부파일 정보를 가져와서 프로퍼티 소스에 추가
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
			System.out.println("@# id ===>"+env.getProperty("admin.id"));
			System.out.println("@# pw ===>"+env.getProperty("admin.pw"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//GenericXmlApplicationContext 클래스로 다운 캐스팅
		GenericXmlApplicationContext gctx = (GenericXmlApplicationContext) ctx;
		gctx.load("applicationCTX.xml");
		//객체 생성 전과 객체 생성 시 해당되는 메소드 호출
//		@# setEnvironment()
//		@# afterPropertiesSet()
		gctx.refresh();
		
//		set 프로퍼티를 하기 이전 단계에서 프로퍼티를 세팅해놔서 바로 불러올 수 있음 
		AdminConnection adminConnection = gctx.getBean("adminConnection",AdminConnection.class);
		System.out.println("adminID : "+adminConnection.getAdminID());
		System.out.println("adminPW : "+adminConnection.getAdminPW());
	}
}
