package com.jangyuyuseo.spring.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
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
	
	@GetMapping("/search")
	public String productSearch(@RequestParam("keyword")String keyword, Model model) throws Exception {
		List<ProductDTO> productList = productService.selectKeywordProduct(keyword);
		model.addAttribute("productList",productList);
		model.addAttribute("size",productList.size());
		return "product/search";
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
	  (@Valid @ModelAttribute("productDTO") ProductDTO productDTO, BindingResult result, MultipartFile file, HttpServletRequest request, Model model) throws IOException, Exception {
	  	
	  	if(result.hasErrors()) {
	  		return "product/register";
	  	}
	
	  	System.out.println(productDTO.getPr_detail());
	  	
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
	  	
	  	int pr_id = productService.getProductId(productDTO.getPr_name());
	  	
	  	model.addAttribute("pr_id", pr_id);
	  	
	  	return "product/register_success";
	  }
	

	@RequestMapping(value="/uploadSummernoteImageFile", produces = "application/json; charset=utf8")
	@ResponseBody
	public String uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request )  {
		JsonObject jsonObject = new JsonObject();
		
		String fileRoot = "C:\\Users\\uplay\\GitHub\\JangYuYuSeo\\JangYuYuSeo\\WebContent\\resources\\summernote_images\\";	//????????? ?????? ?????? ??????
		
		//fileRoot = "C:\\Users\\uplay\\Github\\JangYuYuSeo\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\JangYuYuSeo\\resources\\summernote_images\\";
		

		fileRoot = request.getSession().getServletContext().getRealPath("/")+"/resources/summernote_images/";
		
		String originalFileName = multipartFile.getOriginalFilename();	//???????????? ?????????
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//?????? ?????????
		String savedFileName = UUID.randomUUID() + extension;	//????????? ?????? ???
		
		File targetFile = new File(fileRoot + savedFileName);	
		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);	//?????? ??????
			jsonObject.addProperty("url", "/resources/summernote_images/"+ savedFileName); // contextroot + resources + ????????? ?????? ?????????
			jsonObject.addProperty("responseCode", "success");
				
		} catch (IOException e) {
			FileUtils.deleteQuietly(targetFile);	//????????? ?????? ??????
			jsonObject.addProperty("responseCode", "error");
			e.printStackTrace();
		}
		String a = jsonObject.toString();
		return a; 
	}
}
