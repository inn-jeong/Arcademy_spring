package com.lgy.spring_8_3_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
///개발서버 정보
public class ApplicationConfigDev {
	@Bean
	public ServerInfo serverInfo() {
		ServerInfo info = new ServerInfo();
		info.setIpNum("localhost");
		info.setPortNum("8181");
		
		return info;
	}
}
