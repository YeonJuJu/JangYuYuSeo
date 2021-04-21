package com.jangyuyuseo.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.jangyuyuseo.spring.dto.ProductDTO;
public interface ProductMapper {
	
	@Select("select * from product_table")
	public List<ProductDTO> selectAllProduct();
	
	@Select("select * from product_table where pr_category=#{category_idx}")
	public List<ProductDTO> selectCategoryProduct(int category_idx);
	
	@Insert("insert into product_table VALUES(product_seq.nextval, #{pr_name}, #{pr_description}, #{pr_price}, #{pr_size}, "
			+ "#{pr_color}, #{pr_detail}, #{pr_stock}, #{pr_sales}, TO_DATE(#{pr_date},'YYYYMMDD'), #{pr_category}, #{pr_image})")
	public void addProdcut(ProductDTO productDTO);

} 
