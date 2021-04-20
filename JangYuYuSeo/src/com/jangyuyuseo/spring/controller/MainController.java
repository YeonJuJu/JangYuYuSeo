package com.jangyuyuseo.spring.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jangyuyuseo.spring.service.ProductService;
import com.jangyuyuseo.spring.service.UserService;

@Controller
public class MainController {


	@Autowired
	private ProductService productService;
	
	@GetMapping("/main")
	public String main(Model model) throws Exception {
	
		List productList = productService.selectAllProduct();
		System.out.println(productList);
		model.addAttribute("productList",productList);
		
		return "main";
	}
}
