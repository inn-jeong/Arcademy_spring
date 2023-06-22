package com.lgy.spring_validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//Validator : 스프링에서 제공하는 기본 validation 인터페이스
public class StudentValidator implements Validator{

	//supports: 커멘드 객체 지정(dto 해당)
//	<?>: 제네릭 타입파라미터를 어떤 것이라도 받아줌(ex>String, Integer)
	@Override
	public boolean supports(Class<?> clazz) {
		//커맨드 객체를 clazz 매개변수로 부터 배치됨(validation 체크 대상이 됨)
		return Student.class.isAssignableFrom(clazz);
	}

	//targer: 커맨드 객체, errors: 결과값 받는 객체
	@Override
	public void validate(Object target, Errors errors) {
		log.info("@# validate()");
		Student student = (Student)target;
		
		String id = student.getId();
		if(id=="" || id.trim().isEmpty()) {
			log.info("@# id is null or empty");
			//결과값 객체에 id가 문제 생겼다고 리턴
			errors.rejectValue("id", "trouble");
		}
		
		String pw = student.getPw();
		if(pw=="" || pw.trim().isEmpty()) {
			log.info("@# pw is null or empty");
			errors.rejectValue("pw", "trouble");
		}
	}
	
	

}
