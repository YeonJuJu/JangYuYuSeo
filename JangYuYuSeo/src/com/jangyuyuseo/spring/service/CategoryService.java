package com.jangyuyuseo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jangyuyuseo.spring.dao.CategoryDAO;
import com.jangyuyuseo.spring.dto.CategoryDTO;

@Service
public class CategoryService {
	@Autowired
	private CategoryDAO categoryDAO;

	public List<CategoryDTO> getCategoryList(){
		List<CategoryDTO> categoryList = categoryDAO.getCategoryList();
		
		return categoryList;
	}
	
	public String getCategoryName(int category_idx) {
		return categoryDAO.getCategoryName(category_idx);
	}
}
