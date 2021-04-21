package com.jangyuyuseo.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jangyuyuseo.spring.dto.CategoryDTO;
import com.jangyuyuseo.spring.mapper.CategoryMapper;

@Repository
public class CategoryDAO {
	@Autowired
	private CategoryMapper categoryMapper;
	
	public List<CategoryDTO> getCategoryList(){
		List<CategoryDTO> categoryList = categoryMapper.getCategoryList();
		return categoryList;
	}
	
	
	//new, best 제외한 카테고리 리스트
	public List<CategoryDTO> getCategoryList2(){
		List<CategoryDTO> categoryList = categoryMapper.getCategoryList2();
		return categoryList;
	}
	
	
	public String getCategoryName(int category_idx) {
		return categoryMapper.getCategoryName(category_idx);
	}
}
