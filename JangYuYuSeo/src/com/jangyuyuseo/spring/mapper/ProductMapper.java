package com.jangyuyuseo.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jangyuyuseo.spring.dto.ProductDTO;
public interface ProductMapper {
	
	@Select("select * from product_table")
	public List<ProductDTO> selectAllProduct();
	
	@Select("select * from (select * from product_table order by pr_sales desc) where rownum <= 6")
	public List<ProductDTO> selectBestProduct();

	@Select("select * from (select * from product_table order by pr_date desc) where rownum <= 6")
	public List<ProductDTO> selectNewProduct();
	
	@Select("select * from product_table where pr_category=#{category_idx}")
	public List<ProductDTO> selectCategoryProduct(int category_idx);
	
	@Select("select * from product_table where pr_id=#{pr_id}")
	public ProductDTO selectProductById(int pr_id);

	@Delete("delete from product_table where pr_id = #{pr_id}")
	public void deleteProduct(int pr_id);

	@Update("update product_table "
			+ "set pr_id = #{pr_id},"
			+ "pr_name = #{pr_name},"
			+ "pr_description = #{pr_description},"
			+ "pr_price = #{pr_price},"
			+ "pr_size = #{pr_size},"
			+ "pr_color = #{pr_color},"
			+ "pr_image = #{pr_image},"
			+ "pr_detail = #{pr_detail},"
			+ "pr_stock = #{pr_stock},"
			+ "pr_sales = #{pr_sales},"
			+ "pr_date = TO_DATE(#{pr_date},'YYYYMMDD'),"
			+ "pr_category = #{pr_category}"
			+ "where pr_id = #{pr_id}")
	public void updateProduct(ProductDTO productDTO);
	
	@Insert("insert into product_table VALUES(product_seq.nextval, #{pr_name}, #{pr_description}, #{pr_price}, #{pr_size}, "
			+ "#{pr_color}, #{pr_detail}, #{pr_stock}, #{pr_sales}, TO_DATE(#{pr_date},'YYYYMMDD'), #{pr_category}, #{pr_image})")
	public void addProdcut(ProductDTO productDTO);

} 
