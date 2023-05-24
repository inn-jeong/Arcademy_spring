package com.lgy.spring_ex8_4;

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
			propertySources.addLast(new ResourcePropertySource("classpath:jdbc.driver"));
			System.out.println(env.getProperty("oracle"));
			System.out.println(env.getProperty("mysql"));
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		GenericXmlApplicationContext gctx = (GenericXmlApplicationContext)ctx;
		gctx.load("applicationCTX.xml");
		gctx.refresh();
		JdbcDriver jdbcDriver = gctx.getBean("jdbcDriver",JdbcDriver.class);
		System.out.println("OracleJdbcDriver: "+jdbcDriver.getOracleJdbcDriver());
		System.out.println("MysqlJdbcDriver :"+jdbcDriver.getMysqlJdbcDriver());
	}
}
