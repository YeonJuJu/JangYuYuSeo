package com.jangyuyuseo.spring.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jangyuyuseo.spring.dto.ProductDTO;
import com.jangyuyuseo.spring.mapper.ProductMapper;

@Repository
public class ProductDAO {

	@Autowired
	private ProductMapper productMapper;
	
	public List<ProductDTO> selectAllProduct(){
		return productMapper.selectAllProduct();
	}
	
	public List<ProductDTO> selectBestProduct(){
		return productMapper.selectBestProduct();
	}

	public List<ProductDTO> selectNewProduct(){
		return productMapper.selectNewProduct();
	}
	
	public List<ProductDTO> selectCategoryProduct(int category_idx){
		return productMapper.selectCategoryProduct(category_idx);
		
	}
	
	public void addProduct(ProductDTO productDTO) {
		productDTO.setPr_sales(0);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		productDTO.setPr_date(dateFormat.format(Calendar.getInstance().getTime()));
		productMapper.addProdcut(productDTO);
	}
	
}
