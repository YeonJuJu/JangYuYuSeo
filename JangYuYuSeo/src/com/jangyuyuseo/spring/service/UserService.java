package com.jangyuyuseo.spring.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jangyuyuseo.spring.dao.UserDAO;
import com.jangyuyuseo.spring.dto.UserDTO;

@Service
public class UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Resource(name = "loginUserDTO")
	private UserDTO loginUserDTO;
	
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
	
	public void getLoginUser(UserDTO tmlLoginUserDTO) {
	
		UserDTO fromDBUserDTO = userDAO.getLoginUser(tmlLoginUserDTO);
		
		if(fromDBUserDTO != null) {
			loginUserDTO.setUser_idx(fromDBUserDTO.getUser_idx());
			loginUserDTO.setUser_name(fromDBUserDTO.getUser_name());
			loginUserDTO.setUser_address(fromDBUserDTO.getUser_address());
			loginUserDTO.setUser_signupdate(fromDBUserDTO.getUser_signupdate());
			loginUserDTO.setUserLogin(true);
		}
	}
	
	public void getUserInfo(UserDTO modifyUserDTO, UserDTO checkUserDTO) {
		UserDTO modifyUserInfo = userDAO.getUserInfo(checkUserDTO);
		
		if(modifyUserInfo != null) {
			modifyUserDTO.setUser_idx(modifyUserInfo.getUser_idx());
			modifyUserDTO.setUser_id(modifyUserInfo.getUser_id());
			modifyUserDTO.setUser_password(modifyUserInfo.getUser_password());
			modifyUserDTO.setUser_address(modifyUserInfo.getUser_address());
			modifyUserDTO.setUser_name(modifyUserInfo.getUser_name());
			modifyUserDTO.setUser_phone(modifyUserInfo.getUser_phone());	
			modifyUserDTO.setUser_signupdate(loginUserDTO.getUser_signupdate());
		}

	}
	
	public void modifyUserInfo(UserDTO modifyUserDTO) {
		modifyUserDTO.setUser_idx(loginUserDTO.getUser_idx());
		userDAO.modifyUserInfo(modifyUserDTO);
	}
}
