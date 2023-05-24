package com.lgy.spring_ex8_3;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String config="";
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		
		if(str.equals("oracle")) {
			config="oracle";
		}else if(str.equals("mysql")) {
			config="mysql";
		}
		scan.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load("oracleCTX.xml","mysqlCTX.xml");
		DbInfo info = ctx.getBean("dbInfo",DbInfo.class);
		System.out.println("driver: "+info.getDriver());
		System.out.println("url: "+info.getUrl());
		System.out.println("user: "+info.getUser());
		System.out.println("password: "+info.getPassword());
	}
}
