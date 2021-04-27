package com.jangyuyuseo.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jangyuyuseo.spring.dto.CartDTO;
import com.jangyuyuseo.spring.dto.CartProductDTO;
import com.jangyuyuseo.spring.dto.ProductDTO;
import com.jangyuyuseo.spring.dto.UserDTO;
import com.jangyuyuseo.spring.service.CartProductService;
import com.jangyuyuseo.spring.service.CartService;
import com.jangyuyuseo.spring.service.CategoryService;
import com.jangyuyuseo.spring.service.ProductService;
import com.jangyuyuseo.spring.utils.UploadFileUtils;


@Controller
@RequestMapping("/cart")
public class CartController {


	@Resource(name="loginUserDTO")
	private UserDTO loginUserDTO;
	
	@Autowired
	private CartService cartService;
	@Autowired
	private CartProductService cartProductService;
	@Autowired
	private ProductService productService;
	
	private int cartInsert(int pr_id, String color, String size) {
		CartProductDTO cartProductDTO = new CartProductDTO();
		int userIdx = loginUserDTO.getUser_idx();
		CartDTO cartDTO = cartService.findCartDTOByUserId(userIdx);
		if(cartDTO == null) {
			cartService.addCartDTO(userIdx);
			cartDTO = cartService.findCartDTOByUserId(userIdx);
		}
		int cartId = cartDTO.getCart_id();
		ProductDTO productDTO = productService.selectProductById(pr_id);
		cartProductDTO.setCart_id(cartId);
		cartProductDTO.setPr_id(pr_id);
		cartProductDTO.setPr_image(productDTO.getPr_image());
		cartProductDTO.setPr_name(productDTO.getPr_name());
		cartProductDTO.setPr_price(productDTO.getPr_price());
		
		cartProductDTO.setPr_color(color);
		cartProductDTO.setPr_size(size);
		return cartProductService.addCartProduct(cartProductDTO,cartId);
	}
	@GetMapping("/list")
	public String cart(Model model) {
		List<CartProductDTO> cartProductList = null;
		int cartId = 0;
		if(loginUserDTO.isUserLogin() == true) {
			int userIdx = loginUserDTO.getUser_idx();
			cartId = cartService.findCartDTOByUserId(userIdx).getCart_id();
			cartProductList = cartProductService.findProductListByCartId(cartId);
		}
		model.addAttribute("cartId",cartId);
		model.addAttribute("cartProductList",cartProductList);
		return "order/cart";
	}

	@PostMapping("/insert")
	  public String cartInsertProc (@RequestParam("product_id") int pr_id, HttpSession session) {
		if(loginUserDTO.isUserLogin() == true) {
			//색이랑 사이즈 display에서 가져와야 됨 ㅠㅠ잘 안돼서 임의의 값 넣어놓음 
			cartInsert(pr_id,"black","free");
		  	return "redirect:list";
		}else {
			return "user/login";
		}
	  }
	
	@GetMapping("/orderform")
	public String orderForm(@RequestParam("product_id") int pr_id, Model model) {
		//장바구니 넣는거 어떻게 할 지 몰라서 그냥 .. 복붙해옴 ㅎㅎ 함수로 만들어서 쓰면 되나 ..?
		if(loginUserDTO.isUserLogin() == true) {
			//색이랑 사이즈 display에서 가져와야 됨 ㅠㅠ잘 안돼서 임의의 값 넣어놓음 
			int cartPrId = cartInsert(pr_id,"black","free");
			
			List<CartProductDTO> cartProductList = new ArrayList<CartProductDTO>();
			CartProductDTO orderProductDTO = cartProductService.findProductByCartPrId(cartPrId);
			cartProductList.add(orderProductDTO);
			model.addAttribute("cartProductList",cartProductList);
		  	return "order/order_form";
		}else {
			return "user/login";
		}
	}
	
	@GetMapping("/orderform_cart")
	public String orderFormCart(@RequestParam("cart_id") int cart_id,Model model){
		List<CartProductDTO> cartProductList = null;
		if(loginUserDTO.isUserLogin() == true) {
			int userIdx = loginUserDTO.getUser_idx();
			int cartId = cartService.findCartDTOByUserId(userIdx).getCart_id();
			cartProductList = cartProductService.findProductListByCartId(cartId);
			model.addAttribute("cartProductList",cartProductList);
			return "order/order_form";
		}
		else {
			return "user/login";
		}
	}
	@PostMapping("/plus_amount")
	 public String cartPlusProc (@RequestParam("cart_product_id") int cart_pr_id) {
		int amount = cartProductService.findProductByCartPrId(cart_pr_id).getPr_amount() + 1;
		cartProductService.updateCartProductAmount(amount, cart_pr_id);
		return "redirect:list";
	  }
	@PostMapping("/minus_amount")
	 public String cartMinusProc (@RequestParam("cart_product_id") int cart_pr_id) {
		int amount = cartProductService.findProductByCartPrId(cart_pr_id).getPr_amount() - 1;
		cartProductService.updateCartProductAmount(amount, cart_pr_id);
		return "redirect:list";
	  }
}
