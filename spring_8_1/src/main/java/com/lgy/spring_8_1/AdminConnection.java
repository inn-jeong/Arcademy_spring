package com.lgy.spring_8_1;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements InitializingBean, EnvironmentAware{
	//Environment : 환경객체로 시스템 설정 값들 저장
	private Environment env;//객체 생성 전에 environment 객체를 받아서 저장
	private String adminID;
	private String adminPW;

	//객체 생성 전 호출(1번)
	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("@# setEnvironment()");
		//환경객체를 env에 저장
		setEnv(environment);
	}
	//객체 생성 시 호출(2번)
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("@# afterPropertiesSet()");
		//프로퍼티에 있는 정보 -> admin.id, admin.pw
		//프로퍼티 소스에서 admin 아이디를 가져와서 adminID에 저장
		setAdminID(env.getProperty("admin.id"));
		//프로퍼티 소스에서 admin 비밀번호를 가져와서 adminPW에 저장
		setAdminPW(env.getProperty("admin.pw"));
	}
	
	public Environment getEnv() {
		return env;
	}
	public void setEnv(Environment env) {
		this.env = env;
	}
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	public String getAdminPW() {
		return adminPW;
	}
	public void setAdminPW(String adminPW) {
		this.adminPW = adminPW;
	}

}
