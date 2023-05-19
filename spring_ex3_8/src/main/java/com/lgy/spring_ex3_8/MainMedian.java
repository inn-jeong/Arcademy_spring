package com.lgy.spring_ex3_8;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainMedian {
	public static void main(String[] args) {
		String confLoc = "classpath:medianCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(confLoc);
		
		MyMedian myMedian = ctx.getBean("myMedian",MyMedian.class);
		
		myMedian.pc();
	}
}
