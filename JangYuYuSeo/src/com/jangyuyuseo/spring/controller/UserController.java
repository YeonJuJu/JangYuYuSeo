package com.jangyuyuseo.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jangyuyuseo.spring.dto.UserDTO;
import com.jangyuyuseo.spring.service.UserService;
import com.jangyuyuseo.spring.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
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
