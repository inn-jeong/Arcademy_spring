package com.lgy.spring_8_3_2;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String config = "";
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		
		if(str.equals("dev")) {//개발서버일떼
			config="dev";
		}else if(str.equals("run")) {//운영서버일때
			config="run";
		}
		scan.close();
		
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ctx.getEnvironment().setActiveProfiles(config);//dev or run
		//dev or run 값을 가지고 프로파일 속성을 찾아감(xml 하나 선택됨)
//		ctx.load("applicationCTX_dev.xml","applicationCTX_run.xml");

		//java 방식
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);//dev or run
		//register 메소드: class 등록
		ctx.register(ApplicationConfigDev.class, ApplicationConfigRun.class);
		ctx.refresh();
		ServerInfo info = ctx.getBean("serverInfo",ServerInfo.class);
		System.out.println("ip: "+info.getIpNum());
		System.out.println("port: "+info.getPortNum());
	}
}
