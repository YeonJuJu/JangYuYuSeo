package com.jangyuyuseo.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.jangyuyuseo.spring.dto.CategoryDTO;

public interface CategoryMapper {
	@Select("SELECT * FROM CATEGORY_TABLE ORDER BY CATEGORY_IDX")
	public List<CategoryDTO> getCategoryList();
}
