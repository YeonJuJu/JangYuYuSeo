package com.jangyuyuseo.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jangyuyuseo.spring.dto.CartDTO;
import com.jangyuyuseo.spring.dto.CartProductDTO;
import com.jangyuyuseo.spring.dto.ProductDTO;
import com.jangyuyuseo.spring.dto.UserDTO;
import com.jangyuyuseo.spring.service.CartProductService;
import com.jangyuyuseo.spring.service.CartService;
import com.jangyuyuseo.spring.service.ProductService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Resource(name="loginUserDTO")
	private UserDTO loginUserDTO;
	
	@Autowired
	private CartService cartService;
	@Autowired
	private CartProductService cartProductService;
	@Autowired
	private ProductService productService;
	
	@GetMapping("/orderform")
	public String orderForm(@Valid @ModelAttribute("cartProductDTO") CartProductDTO cartProductDTO, @RequestParam("product_id") int pr_id, Model model) {
		//장바구니 넣는거 어떻게 할 지 몰라서 그냥 .. 복붙해옴 ㅎㅎ 함수로 만들어서 쓰면 되나 ..?
		if(loginUserDTO.isUserLogin() == true) {
			System.out.println(cartProductDTO.getPr_color()+" "+cartProductDTO.getPr_size());
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
			
			//display에서 가져와야 됨 ㅠㅠ잘 안돼서 임의의 값 넣어놓음 
			cartProductDTO.setPr_color("black");
			cartProductDTO.setPr_size("free");
			int cartPrId = cartProductService.addCartProduct(cartProductDTO,cartId);
			
			List<CartProductDTO> cartProductList = new ArrayList<CartProductDTO>();
			CartProductDTO orderProductDTO = cartProductService.findProductByCartId(cartPrId);
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
}
