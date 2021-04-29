package com.jangyuyuseo.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jangyuyuseo.spring.dto.CartDTO;
import com.jangyuyuseo.spring.dto.CartProductDTO;
import com.jangyuyuseo.spring.dto.OrderDTO;
import com.jangyuyuseo.spring.dto.ProductDTO;
import com.jangyuyuseo.spring.dto.UserDTO;
import com.jangyuyuseo.spring.service.CartProductService;
import com.jangyuyuseo.spring.service.CartService;
import com.jangyuyuseo.spring.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Resource(name = "loginUserDTO")
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
		if (cartDTO == null) {
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
		return cartProductService.addCartProduct(cartProductDTO, cartId);
	}

	@GetMapping("/list")
	public String cart(Model model) {
		List<CartProductDTO> cartProductList = null;
		int cartId = 0;
		int total = 0;
		if (loginUserDTO.isUserLogin() == true) {
			int userIdx = loginUserDTO.getUser_idx();
			cartId = cartService.findCartDTOByUserId(userIdx).getCart_id();
			cartProductList = cartProductService.findProductListByCartId(cartId);
			int len = cartProductList.size();
			for(int i=0;i<len;i++)
				total+=cartProductList.get(i).getTotal_price();
		}
		model.addAttribute("total",total);
		model.addAttribute("cartId", cartId);
		model.addAttribute("cartProductList", cartProductList);
		return "order/cart";
	}

	@PostMapping("/insert")
	public String cartInsertProc(@ModelAttribute("tmpLoginUserDTO") UserDTO tmpLoginUserDTO,
			@RequestParam("product_id") int pr_id, 
			@RequestParam("color") String color,
			@RequestParam("size") String size) {
		if (loginUserDTO.isUserLogin() == true) {
			// 색이랑 사이즈 display에서 가져와야 됨 ㅠㅠ잘 안돼서 임의의 값 넣어놓음
			cartInsert(pr_id, color, size);
			return "redirect:list";
		} else {
			return "user/login";
		}
	}

	@GetMapping("/orderform")
	public String orderForm(@ModelAttribute("tmpLoginUserDTO") UserDTO tmpLoginUserDTO,
			@RequestParam(value = "product_id", required=false , defaultValue = "-1" ) int pr_id,
			@RequestParam(value = "color", required=false) String color,
			@RequestParam(value = "size", required=false) String size,
			Model model) {
		if(loginUserDTO.isUserLogin() == true) {
			List<CartProductDTO> cartProductList = new ArrayList<CartProductDTO>();
			//장바구니에서 넘어온 경우
			if(pr_id == -1) {
				int userIdx = loginUserDTO.getUser_idx();
				int cartId = cartService.findCartDTOByUserId(userIdx).getCart_id();
				cartProductList = cartProductService.findProductListByCartId(cartId);
			}
			//주문하기로 넘어온 경우 
			else {
				int cartPrId = cartInsert(pr_id,color,size);
				CartProductDTO orderProductDTO = cartProductService.findProductByCartPrId(cartPrId);
				cartProductList.add(orderProductDTO);
			}
			int total = 0;
			int len = cartProductList.size();
			for(int i=0;i<len;i++)
				total+=cartProductList.get(i).getTotal_price();
			model.addAttribute("total",total);
			model.addAttribute("cartProductList", cartProductList);
			return "order/order_form";
		} else {
			return "user/login";
		}
	}

	@PostMapping("/update_amount")
	 public String cartUpdateProc (@RequestParam("cart_product_id") int cart_pr_id, @RequestParam("amount") int amount) {
		cartProductService.updateCartProductAmount(amount, cart_pr_id);
		return "redirect:list";
	  }
	//지금은 플마로 원하는 수량 설정하고 변경눌러야 변경되는데 플마 누를때마다 디비에 반영할지 고민이라 걍 안지우고 넣어 둠 근데 그렇게 하면 누를때마다 화면 새로고침 돼서 조금 정신 없긴 하더라 ㅜㅜ

	@PostMapping("/plus_amount")
	public String cartPlusProc(@RequestParam("cart_product_id") int cart_pr_id) {
		int amount = cartProductService.findProductByCartPrId(cart_pr_id).getPr_amount() + 1;
		cartProductService.updateCartProductAmount(amount, cart_pr_id);
		return "redirect:list";
	}

	@PostMapping("/minus_amount")
	public String cartMinusProc(@RequestParam("cart_product_id") int cart_pr_id) {
		int amount = cartProductService.findProductByCartPrId(cart_pr_id).getPr_amount() - 1;
		cartProductService.updateCartProductAmount(amount, cart_pr_id);
		return "redirect:list";
	}
	
	@RequestMapping("/cartProductDelete")
	public String cartProductDeleteProc(@RequestParam("cart_product_id")int cart_pr_id) throws Exception {
		cartProductService.deleteCartProduct(cart_pr_id);
		return "redirect:list";
	}
}
