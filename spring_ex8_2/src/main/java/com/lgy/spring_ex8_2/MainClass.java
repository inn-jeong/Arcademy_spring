package com.lgy.spring_ex8_2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		DbConnection dbConnection = ctx.getBean("dbConnection",DbConnection.class);
		System.out.println("mssqlID: "+dbConnection.getMssqlId());
		System.out.println("mssqlPW: "+dbConnection.getMssqlPw());
		System.out.println("mysqlID: "+dbConnection.getMysqlId());
		System.out.println("mysqlPW: "+dbConnection.getMysqlPw());
	}
}
