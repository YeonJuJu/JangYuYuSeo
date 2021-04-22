package com.jangyuyuseo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jangyuyuseo.spring.dto.ProductDTO;
import com.jangyuyuseo.spring.service.ProductService;

@Controller
public class MainController {


	@Autowired
	private ProductService productService;
	
	@GetMapping("/main")
	public String main(Model model) throws Exception {
		
		List<ProductDTO> bestProductList = productService.selectBestProduct();
		List<ProductDTO> newProductList = productService.selectNewProduct();
		model.addAttribute("bestProductList",bestProductList);
		model.addAttribute("newProductList",newProductList);
		
		return "main";
	}
}
