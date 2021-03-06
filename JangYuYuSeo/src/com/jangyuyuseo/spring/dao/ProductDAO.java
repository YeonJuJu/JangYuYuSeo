package com.jangyuyuseo.spring.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
	
	public ProductDTO selectProductById(int pr_id) {
		return productMapper.selectProductById(pr_id);
	}
	
	public List<ProductDTO> selectKeywordProduct(String keyword) throws Exception {
		return productMapper.selectKeywordProduct(keyword);
	}

	public void deleteProduct(int pr_id) {
		productMapper.deleteProduct(pr_id);
	}

	public void updateProduct(ProductDTO productDTO,int pr_id) {
		ProductDTO preProductDTO = selectProductById(pr_id);
		productDTO.setPr_id(preProductDTO.getPr_id());
		productDTO.setPr_sales(preProductDTO.getPr_sales());

		SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat afterFormat = new SimpleDateFormat("yyyyMMdd");
		Date tempDate = null;
		try {
			tempDate = beforeFormat.parse(preProductDTO.getPr_date());
		} catch (ParseException e) {
		}
		productDTO.setPr_date(afterFormat.format(tempDate));

		productMapper.updateProduct(productDTO);
	}
	
	public void addProduct(ProductDTO productDTO) {
		productDTO.setPr_sales(0);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		productDTO.setPr_date(dateFormat.format(Calendar.getInstance().getTime()));
		productMapper.addProdcut(productDTO);
	}
	
	public int getProductId(String pr_name) {
		return productMapper.getProductId(pr_name);
	}
	
}
