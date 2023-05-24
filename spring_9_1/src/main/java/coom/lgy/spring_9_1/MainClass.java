package coom.lgy.spring_9_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Student student = ctx.getBean("student",Student.class);
		//학생정보 출력(핵심기능 - 메소드)
		student.getStudentInfo();
		
		Worker worker = ctx.getBean("worker",Worker.class);
		worker.getWorkerInfo();
		//공통기능
		//
	}
}
