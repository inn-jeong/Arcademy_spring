package com.lgy.spring_ex8_1;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources();
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:oracle.account"));
			System.out.println(env.getProperty("emp.id"));
			System.out.println(env.getProperty("emp.pw"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		GenericXmlApplicationContext gctx = (GenericXmlApplicationContext)ctx;
		gctx.load("applicationCTX.xml");
		gctx.refresh();
		EmpConnection empConnection = gctx.getBean("empConnection",EmpConnection.class);
		System.out.println("empId: "+empConnection.getEmpId());
		System.out.println("empPw: "+empConnection.getEmpPw());
	}
}
