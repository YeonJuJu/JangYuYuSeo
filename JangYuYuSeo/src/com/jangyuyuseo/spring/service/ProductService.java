package com.jangyuyuseo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jangyuyuseo.spring.dao.ProductDAO;
import com.jangyuyuseo.spring.dto.ProductDTO;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public List<ProductDTO> selectAllProduct() throws Exception {
		return productDAO.selectAllProduct();
	}
	
	public void addProduct(ProductDTO productDTO) {
		productDAO.addProduct(productDTO);
	}
	
}
