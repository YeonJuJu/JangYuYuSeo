package com.jangyuyuseo.spring.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jangyuyuseo.spring.service.CategoryService;
import com.jangyuyuseo.spring.service.ProductService;
import com.jangyuyuseo.spring.service.UserService;


@Controller
public class MainController {


	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/main")
	public String main(@RequestParam(value="category_idx",required=false, defaultValue="0") int category_idx, Model model) throws Exception {
		
		System.out.println(category_idx);
		List productList; 
		String category;
		if(category_idx==0) {
			productList = productService.selectAllProduct();
			category = "Total";
		}
		else {
			if(category_idx==1)
				productList = productService.selectBestProduct();
			else if(category_idx==2)
				productList = productService.selectNewProduct();
			else
				productList = productService.selectCategoryProduct(category_idx);
			category = categoryService.getCategoryName(category_idx);
		}
		
		model.addAttribute("productList",productList);
		model.addAttribute("category",category);
		
		return "main";
	}
}
