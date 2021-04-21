package com.jangyuyuseo.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.jangyuyuseo.spring.dto.CategoryDTO;
import com.jangyuyuseo.spring.dto.ProductDTO;

public interface CategoryMapper {
	@Select("SELECT * FROM CATEGORY_TABLE ORDER BY CATEGORY_IDX")
	public List<CategoryDTO> getCategoryList();
	
	//new, best 제외한 카테고리 리스트 
	@Select("SELECT * FROM CATEGORY_TABLE WHERE CATEGORY_IDX > 2 ORDER BY CATEGORY_IDX")
	public List<CategoryDTO> getCategoryList2();
	
	@Select("select category_name from category_table where category_idx=#{category_idx}")
	public String getCategoryName(int category_idx);

}

