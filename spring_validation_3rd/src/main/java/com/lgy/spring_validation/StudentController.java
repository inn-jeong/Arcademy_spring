package com.lgy.spring_validation;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StudentController {
	
	@RequestMapping("/studentForm")
	public String studentForm() {
		
		return "createPage";
	}
	
//	student: 커맨드 객체(dto로 주로 이동)
//	BindingResult: 스프링에서 제공하는 기본 validation 결과 인터페이스
	@RequestMapping("/student/create")
	public String studentCreate(@Valid Student student, BindingResult result) {
		String page = "createDonePage";
		
		//StudentValidator: 공통기능 validator 체크하는 클래스 객체
//		StudentValidator validator = new StudentValidator();
//		validator.validate(student, result);
		
//		errors.rejectValue 메소드가 호출되면 result.hasErrors()가 참
		if(result.hasErrors()) {
			log.info("@# result.hasErrors()"+result.getFieldError("id"));
			log.info("@# result.hasErrors()"+result.getFieldError("pw"));
			page="createPage";
		}
		return page;
	}
	
	//@Valid Student 객체 유효성 검사
	@InitBinder
	public void initBinber(WebDataBinder binder) {
		//student 객체를 binder로 받아서 StudentValidator 객체를 사용해서 유효성 체크
		binder.setValidator(new StudentValidator());
	}
}
