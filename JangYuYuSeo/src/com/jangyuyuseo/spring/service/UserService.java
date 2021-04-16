package com.jangyuyuseo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jangyuyuseo.spring.dao.UserDAO;
import com.jangyuyuseo.spring.dto.UserDTO;

@Service
public class UserService {
	@Autowired
	private UserDAO userDAO;
	
	public void addUserInfo(UserDTO joinUserDTO) {
		userDAO.addUserInfo(joinUserDTO);
	}
}
