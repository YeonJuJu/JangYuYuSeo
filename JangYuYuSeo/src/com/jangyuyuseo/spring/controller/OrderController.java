package com.jangyuyuseo.spring.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jangyuyuseo.spring.dto.OrderDTO;
import com.jangyuyuseo.spring.dto.UserDTO;
import com.jangyuyuseo.spring.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Resource(name = "loginUserDTO")
	private UserDTO loginUserDTO;
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order_proc")
	public String orderProc(@ModelAttribute("orderDTO") OrderDTO orderDTO, Model model, BindingResult result) {
		
		//orderDTO에 있는 내용과 로그인 유저아이디 따와서 데이터베이스에 추가
		orderDTO.setOrder_user_idx(loginUserDTO.getUser_idx());
		
		//order_id 생성한거 가져옴
		int order_id = orderService.getNextOrderIndex();
		
		//가져온 order_id 이용해 OrderDTO 추가
		orderDTO.setOrder_id(order_id);
		orderService.addOrderDTO(orderDTO);
		
		//orderProductDTO는.. 어떻게 추가해야 할지 일단 고민
		
		if(model.getAttribute("cartProductList") == null) {
			System.out.println("null");
		}

		
		return "order/order_success";
	}
	
}
