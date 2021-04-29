package com.jangyuyuseo.spring.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.jangyuyuseo.spring.dto.ProductDTO;
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
	
	@GetMapping("/list")
	public String productList(@RequestParam(value="category_idx", required=false) int category_idx,Model model) throws Exception {
		List<ProductDTO> productList; 
		String category;
		if(category_idx==1)
			productList = productService.selectBestProduct();
		else if(category_idx==2)
			productList = productService.selectNewProduct();
		else
			productList = productService.selectCategoryProduct(category_idx);
		category = categoryService.getCategoryName(category_idx);

		model.addAttribute("productList",productList);
		model.addAttribute("category",category);
		return "product/list";
	}
	
	@GetMapping("/display")
	public String productDisplay(@RequestParam("product_id")int pr_id, Model model) {
		ProductDTO productDTO = productService.selectProductById(pr_id);
		String[] sizeList = productDTO.getPr_size().split(",");
		String[] colorList = productDTO.getPr_color().split(",");
		model.addAttribute("productDTO",productDTO);
		model.addAttribute("sizeList",sizeList);
		model.addAttribute("colorList",colorList);
		return "product/display";
	}

	@GetMapping("/manage")
	public String productManage(Model model) throws Exception {
		List<ProductDTO> productList = productService.selectAllProduct();
		model.addAttribute("productList",productList);
		return "product/manage";
	}

	@GetMapping("/modify")
	public String productModify(@RequestParam("product_id")int pr_id,Model model) throws Exception {
		ProductDTO productDTO = productService.selectProductById(pr_id);
		model.addAttribute("productDTO",productDTO);
		return "product/modify";
	}
	
	@GetMapping("/register")
	public String productRegister(Model model) {
		model.addAttribute("productDTO",new ProductDTO());
		return "product/register";
	}
	
	@RequestMapping("/productDelete")
	public String productDeleteProc(@RequestParam("product_id")int pr_id, Model model) throws Exception {
		productService.deleteProduct(pr_id);
		return "redirect:manage";
	}

	@PostMapping("/modify")
	  public String productModifyProc
	  (@Valid @ModelAttribute("productDTO") ProductDTO productDTO, @RequestParam("product_id")int pr_id, BindingResult result, MultipartFile file, HttpServletRequest request) throws IOException, Exception {

	  	if(result.hasErrors()) {
	  		return "product/modify";
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


	  	productService.updateProduct(productDTO,pr_id);


	  	return "product/modify_success";
	  }
	
	@PostMapping("/register")
	  public String productRegisterProc
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
	  	
	  	productService.addProduct(productDTO);
	  	
	  	
	  	return "product/register_success";
	  }
	
	@PostMapping(value="/uploadSummernoteImageFile", produces = "application/json")
	@ResponseBody
	public JsonObject uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile) {
		
		JsonObject jsonObject = new JsonObject();
		
		String fileRoot = "C:\\summernote_image\\";	//저장될 외부 파일 경로
		String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자
				
		String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
		
		File targetFile = new File(fileRoot + savedFileName);	
		
		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
			jsonObject.addProperty("url", "/summernoteImage/"+savedFileName);
			jsonObject.addProperty("responseCode", "success");
				
		} catch (IOException e) {
			FileUtils.deleteQuietly(targetFile);	//저장된 파일 삭제
			jsonObject.addProperty("responseCode", "error");
			e.printStackTrace();
		}
		
		return jsonObject;
	}
}
