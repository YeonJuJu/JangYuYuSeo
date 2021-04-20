package com.jangyuyuseo.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.jangyuyuseo.spring.dto.UserDTO;

/*
  프로젝트에서 사용하는 Bean을 정의하는 클래스
*/
@Configuration
public class RootAppContext {
	
	@Bean("loginUserDTO")
	@SessionScope
	public UserDTO loginUserDTO() {
		return new UserDTO();
	}
	
}








