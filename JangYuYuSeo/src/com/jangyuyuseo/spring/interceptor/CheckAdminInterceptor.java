package com.jangyuyuseo.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.jangyuyuseo.spring.dto.UserDTO;

public class CheckAdminInterceptor implements HandlerInterceptor{
	private UserDTO loginUserDTO; 
	
	public CheckAdminInterceptor(UserDTO loginUserDTO) {
		this.loginUserDTO = loginUserDTO;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		
		if(loginUserDTO.isUserLogin() == false) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/user/not_admin");
			
			return false;
		}
		
		else if(loginUserDTO.getUser_idx()!=0) {
			
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/user/not_admin");
			
			return false;
		}
		else {
			return true;
		}
	}
}
