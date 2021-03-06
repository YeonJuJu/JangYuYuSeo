package com.jangyuyuseo.spring.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.jangyuyuseo.spring.dto.CategoryDTO;
import com.jangyuyuseo.spring.dto.UserDTO;
import com.jangyuyuseo.spring.service.CategoryService;

public class CategoryInterceptor implements HandlerInterceptor{
	private CategoryService categoryService;
	private UserDTO loginUserDTO;
	
	public CategoryInterceptor(CategoryService categoryService, UserDTO loginUserDTO) {
		this.categoryService = categoryService;
		this.loginUserDTO = loginUserDTO;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		List<CategoryDTO> categoryList = categoryService.getCategoryList();
		
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("loginUserDTO", loginUserDTO);
		
		return true;
	}
}
