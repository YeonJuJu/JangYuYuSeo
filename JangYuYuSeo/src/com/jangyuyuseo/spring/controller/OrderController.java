package com.jangyuyuseo.spring.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jangyuyuseo.spring.dto.CartDTO;
import com.jangyuyuseo.spring.dto.CartProductDTO;
import com.jangyuyuseo.spring.dto.OrderDTO;
import com.jangyuyuseo.spring.dto.OrderProductDTO;
import com.jangyuyuseo.spring.dto.UserDTO;
import com.jangyuyuseo.spring.service.CartProductService;
import com.jangyuyuseo.spring.service.CartService;
import com.jangyuyuseo.spring.service.OrderProductService;
import com.jangyuyuseo.spring.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Resource(name = "loginUserDTO")
	private UserDTO loginUserDTO;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderProductService orderProductService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartProductService cartProductService;
	
	@PostMapping("/order_proc")
	public String orderProc(@ModelAttribute("orderDTO") OrderDTO orderDTO, Model model, BindingResult result) {
		
		//orderDTO에 있는 내용과 로그인 유저아이디 따와서 데이터베이스에 추가
		orderDTO.setOrder_user_idx(loginUserDTO.getUser_idx());
		
		//order_id 생성한거 가져옴
		int order_id = orderService.getNextOrderIndex();
		
		//가져온 order_id 이용해 OrderDTO 추가
		orderDTO.setOrder_id(order_id);
		orderService.addOrderDTO(orderDTO);
		
		//1. cartmapper에 findCartDTOByUserID 이용해 cart_id 뽑아
		CartDTO cartDTO = cartService.findCartDTOByUserId(loginUserDTO.getUser_idx());
		
		//2. cartProductMapper 의 cart_id 이용해 check 된거만 뽑아 
		List<CartProductDTO> cartProductList = cartProductService.findProductListByCartIdWithChecked(cartDTO.getCart_id());

		//3. orderProductDTO 추가
		for(CartProductDTO cartProductDTO : cartProductList) {
			OrderProductDTO orderProductDTO = new OrderProductDTO();
			
			orderProductDTO.setOrder_id(order_id);
			orderProductDTO.setPr_id(cartProductDTO.getPr_id());
			orderProductDTO.setPr_amount(cartProductDTO.getPr_amount());
			orderProductDTO.setPr_color(cartProductDTO.getPr_color());
			orderProductDTO.setPr_size(cartProductDTO.getPr_size());
			
			orderProductService.addOrderProductDTO(orderProductDTO);
			
			//주문 후 장바구니에서 삭제
			cartProductService.deleteCartProduct(cartProductDTO.getCart_pr_id());
		}
		
		return "order/order_success";
	}
	
}
