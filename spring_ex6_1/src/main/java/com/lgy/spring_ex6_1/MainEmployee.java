package com.lgy.spring_ex6_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEmployee {
	public static void main(String[] args) {
		String congfigLoc1 = "classpath:employeeCTX.xml";
		String congfigLoc2 = "classpath:employeeCTX2.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(congfigLoc1,congfigLoc2);
		Employee employee1 = ctx.getBean("employee1",Employee.class);
		System.out.println(employee1.getName());
		System.out.println(employee1.getSalary());
		System.out.println(employee1.getLicense());
		System.out.println("=======================");
		EmployeeInfo employeeInfo = ctx.getBean("employeeInfo1",EmployeeInfo.class);
		Employee employee2 = employeeInfo.getEmployee();
		System.out.println(employee2.getName());
		System.out.println(employee2.getSalary());
		System.out.println(employee2.getLicense());
		System.out.println("=======================");
		Employee employee3 = ctx.getBean("employee3", Employee.class);
		System.out.println(employee3.getName());
		System.out.println(employee3.getSalary());
		System.out.println(employee3.getLicense());
		
		ctx.close();
	}
}
