package com.lgy.spring_8_2_2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//자바 설정파일이다.
@Configuration
public class ApplicationConfig {
//	admin.properties 외부파일의 admin.id 값을 setter로 저장
//	2번 외부파일 값들을 프로퍼티에 저장
	@Value("${admin.id}")
	private String adminId;
	@Value("${admin.pw}")
	private String adminPw;
	@Value("${sub_admin.id}")
	private String sub_adminId;
	@Value("${sub_admin.pw}")
	private String sub_adminPw;
	
	
//	1번 xml의 context:property-placeholer와 동일(외부파일 설정) 
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		Resource[] locations = new Resource[2];
//		ClassPathResource 클래스로 외부파일 설정
		locations[0] = new ClassPathResource("admin.properties");
		locations[1] = new ClassPathResource("sub_admin.properties");
		
//		setLocations 메소드 매개변수로 Resource 인터페이스에 있는 외부파일 정보 사용
		configurer.setLocations(locations);
		return configurer;
	}
	
	@Bean
	public AdminConnection adminConnection() {
		AdminConnection adminConnection = new AdminConnection();
//		3번 프로퍼티에 있는 값들을 adminConnection 객체에 저장
//		1번->2번->3번 (외부파일 값들을 AdminConnection 클래스의 프로퍼티에 저장)
		adminConnection.setAdminID(adminId);
		adminConnection.setAdminPW(adminPw);
		adminConnection.setSub_adminID(sub_adminId);
		adminConnection.setSub_adminPW(sub_adminPw);
		return adminConnection;
	}
}
