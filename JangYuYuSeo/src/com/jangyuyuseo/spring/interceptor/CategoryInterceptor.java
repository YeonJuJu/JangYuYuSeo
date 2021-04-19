package com.jangyuyuseo.spring.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.jangyuyuseo.spring.dto.CategoryDTO;
import com.jangyuyuseo.spring.service.CategoryService;

public class CategoryInterceptor implements HandlerInterceptor{
	private CategoryService categoryService;
	
	public CategoryInterceptor(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		List<CategoryDTO> categoryList = categoryService.getCategoryList();
		request.setAttribute("categoryList", categoryList);
	
		return true;
	}
}
