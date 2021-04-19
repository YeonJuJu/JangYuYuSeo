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
	
	public boolean checkID(String user_id) {
		String checking_id = userDAO.checkID(user_id);
		
		if(checking_id == null) {
			return true;
		}
		else {
			return false;
		}
	}
}
