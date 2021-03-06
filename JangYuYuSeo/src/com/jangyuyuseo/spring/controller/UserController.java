package com.jangyuyuseo.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jangyuyuseo.spring.dto.OrderDTO;
import com.jangyuyuseo.spring.dto.OrderProductDTO;
import com.jangyuyuseo.spring.dto.UserDTO;
import com.jangyuyuseo.spring.service.OrderProductService;
import com.jangyuyuseo.spring.service.OrderService;
import com.jangyuyuseo.spring.service.UserService;
import com.jangyuyuseo.spring.validator.UserValidator;
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderProductService orderProductService;
	
	@Resource(name="loginUserDTO")
	private UserDTO loginUserDTO;
	
	@GetMapping("/login")
	public String login(@ModelAttribute("tmpLoginUserDTO") UserDTO tmpLoginUserDTO, @RequestParam(value="failure", defaultValue="false") boolean failure, Model model) {
		
		model.addAttribute("failure", failure);
		
		return "user/login";
	}
	
	@PostMapping("login_proc")
	public String loginProc(@Valid @ModelAttribute("tmpLoginUserDTO") UserDTO tmpLoginUserDTO, BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/login";
		}
		
		userService.getLoginUser(tmpLoginUserDTO);
		
		if(loginUserDTO.isUserLogin() == true) {
			return "user/login_success";
		}else {
			return "user/login_failure";
		}
	}
	
	@GetMapping("/logout")
	public String logout() {
		loginUserDTO.setUserLogin(false);
		return "user/logout";
	}
	
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserDTO") UserDTO joinUserDTO) {
		return "user/join";
	}
	
	@PostMapping("/join_proc")
	public String joinProc(@Valid @ModelAttribute("joinUserDTO") UserDTO joinUserDTO, BindingResult result) {
	  	
	    if(result.hasErrors()) {
	  		return "user/join";
	  	}
	  	
	  	userService.addUserInfo(joinUserDTO);
	  	
	  	return "user/join_success";
	}
	
	@GetMapping("/myPage")
	public String myPage(Model model) {
		model.addAttribute("loginUserDTO", loginUserDTO);

		List<OrderDTO> orderDTOList = orderService.getOrderListByUserIdx(loginUserDTO.getUser_idx());
		List<OrderProductDTO> orderProductList = new ArrayList<OrderProductDTO>();
		int len = orderDTOList.size();
		for(int i=0;i<len;i++) {
			int orderId = orderDTOList.get(i).getOrder_id();
			List<OrderProductDTO> tmp = orderProductService.getOrderProductListByOrderId(orderId);
			if(tmp!=null)
				orderProductList.addAll(tmp);
		}
		model.addAttribute("orderDTOList", orderDTOList);
		model.addAttribute("orderProductList",orderProductList);
		
		return "/user/myPage";
	}
	
	@GetMapping("/before_modify")
	public String beforeModify(@ModelAttribute("checkUserDTO") UserDTO checkUserDTO) {
		return "user/before_modify";
	}
	
	@PostMapping("/before_modify_proc")
	public String beforeModifyProc(@ModelAttribute("checkUserDTO") UserDTO checkUserDTO, @ModelAttribute("modifyUserDTO") UserDTO modifyUserDTO, BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/before_modify";
		}
		
		checkUserDTO.setUser_idx(loginUserDTO.getUser_idx());
		checkUserDTO.setUser_name(loginUserDTO.getUser_name());
		
		userService.getUserInfo(modifyUserDTO, checkUserDTO);
		
		if(modifyUserDTO.getUser_idx() != loginUserDTO.getUser_idx()) {
			return "user/before_modify_check_failure";
		}
		
		return "user/modify";
	}
	
	@GetMapping("/modify")
	public String modify(@ModelAttribute("modifyUserDTO") UserDTO modifyUserDTO) {		
		return "user/modify";
	}
	
	@PostMapping("/modify_proc")
	public String modifyProc(@Valid @ModelAttribute("modifyUserDTO") UserDTO modifyUserDTO, BindingResult result) {
		
		if(result.hasErrors()){
			return "user/modify";
		}
		
		userService.modifyUserInfo(modifyUserDTO);
		
		userService.getLoginUser(modifyUserDTO);
		
		return "user/modify_success";
	}
	
	@GetMapping("/not_admin")
	public String notAdmain() {
		return "user/not_admin";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator validator1 = new UserValidator();
		binder.addValidators(validator1);
	}
}
