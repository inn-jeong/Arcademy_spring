package com.lgy.spring_ex3_10;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainCapital {
	public static void main(String[] args) {
		String confLoc = "classpath:capitalCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(confLoc);
		
		MyCaplital myCaplital = ctx.getBean("myCapital", MyCaplital.class);
		myCaplital.alpha();
	}
}
