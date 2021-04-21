package com.jangyuyuseo.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.jangyuyuseo.spring.dto.ProductDTO;
import com.jangyuyuseo.spring.dto.UserDTO;
import com.jangyuyuseo.spring.service.CategoryService;
import com.jangyuyuseo.spring.service.ProductService;
import com.jangyuyuseo.spring.utils.UploadFileUtils;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping("/register")
	public String register(Model model) {
		List categoryList = categoryService.getCategoryList();
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("productDTO",new ProductDTO());
		return "product/register";
	}
	
	@PostMapping("/register")
	  public String productRegister
	  (@Valid @ModelAttribute("productDTO") ProductDTO productDTO, BindingResult result, MultipartFile file, HttpServletRequest request) throws IOException, Exception {
	  	
	  	if(result.hasErrors()) {
	  		return "product/register";
	  	}
	

	  	String uploadPath = request.getSession().getServletContext().getRealPath("/")+"/resources";
	  	String imgUploadPath = uploadPath + File.separator + "images";
	  	String fileName = null;

	  	if(file != null) {
	  		fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes());
	  	} else {
	  		fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
	  	}
	   
	  	productDTO.setPr_image(File.separator + "images" + File.separator + fileName);
	  	System.out.println(productDTO.toString());
	  	
	  	productService.addProduct(productDTO);
	  	
	  	
	  	return "product/register_success";
	  }
}
