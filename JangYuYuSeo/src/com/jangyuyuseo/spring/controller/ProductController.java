package com.jangyuyuseo.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jangyuyuseo.spring.dto.ProductDTO;
import com.jangyuyuseo.spring.dto.UserDTO;
import com.jangyuyuseo.spring.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("productDTO",new ProductDTO());
		return "product/register";
	}
	
	@PostMapping("/register")
	  public String productRegister
	  (@Valid @ModelAttribute("productDTO") ProductDTO productDTO, BindingResult result) {
	  	
	  	if(result.hasErrors()) {
	  		return "product/register";
	  	}
	  	
	  	productService.addProduct(productDTO);
	  	
	  	return "product/register_success";
	  }
}
