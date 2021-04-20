package com.jangyuyuseo.spring.controller;

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

import com.jangyuyuseo.spring.dto.UserDTO;
import com.jangyuyuseo.spring.service.UserService;
import com.jangyuyuseo.spring.validator.UserValidator;
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Resource(name="loginUserDTO")
	private UserDTO loginUserDTO;
	
	@GetMapping("/login")
	public String login(@ModelAttribute("loginUserDTO") UserDTO loginUserDTO, @RequestParam(value="failure", defaultValue="false") boolean failure, Model model) {
		
		model.addAttribute("failure", failure);
		
		return "user/login";
	}
	
	@PostMapping("login_proc")
	public String loginProc(@Valid @ModelAttribute("loginUserDTO") UserDTO loginUserDTO, BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/login";
		}
		
		userService.getLoginUser(loginUserDTO);
		
		if(loginUserDTO.isUserLogin() == true) {
			return "user/login_success";
		}else {
			return "user/login_failure";
		}
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
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator validator1 = new UserValidator();
		binder.addValidators(validator1);
	}
}
