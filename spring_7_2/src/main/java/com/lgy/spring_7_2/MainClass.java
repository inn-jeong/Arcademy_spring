package com.lgy.spring_7_2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:applicationCTX.xml");
//		@# afterPropertiesSet()
//		INFO : org.springframework.context.support.GenericXmlApplicationContext - Closing org.springframework.context.support.GenericXmlApplicationContext@2957fcb0: startup date [Mon May 22 14:55:38 KST 2023]; root of context hierarchy
//		INFO : org.springframework.beans.factory.support.DefaultListableBeanFactory - Destroying singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2d3fcdbd: defining beans [student,otherStudent]; root of factory hierarchy
//		@# destroy

//		====================================================
//		context:properties 추가 이루
//		@# afterPropertiesSet()
//		@# initMethod()
//		INFO : org.springframework.context.support.GenericXmlApplicationContext - Closing org.springframework.context.support.GenericXmlApplicationContext@2957fcb0: startup date [Mon May 22 14:57:59 KST 2023]; root of context hierarchy
//		INFO : org.springframework.beans.factory.support.DefaultListableBeanFactory - Destroying singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@36d4b5c: defining beans [org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalRequiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,student,otherStudent,org.springframework.context.annotation.ConfigurationClassPostProcessor$ImportAwareBeanPostProcessor#0]; root of factory hierarchy
//		@# destroyMethod()
//		@# destroy()
		ctx.refresh();
//		ctx.close();
	}
}
