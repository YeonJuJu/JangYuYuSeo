package com.jangyuyuseo.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jangyuyuseo.spring.dto.UserDTO;
import com.jangyuyuseo.spring.mapper.UserMapper;

@Repository
public class UserDAO {
	@Autowired
	private UserMapper userMapper;
	
	public void addUserInfo(UserDTO joinUserDTO) {
		userMapper.addUserInfo(joinUserDTO);
	}
	
	public String checkID(String user_id) {
		String checking_id = userMapper.checkID(user_id);
		return checking_id;
	}
	
	public UserDTO getLoginUser(UserDTO loginUserDTO) {
		UserDTO fromDBUserDTO = userMapper.getLoginUser(loginUserDTO);
		return fromDBUserDTO;
	}
	
	public UserDTO getUserInfo(UserDTO checkUserDTO) {
		UserDTO modifyUserInfo = userMapper.getUserInfo(checkUserDTO);
		return modifyUserInfo;
	}
	
	public void modifyUserInfo(UserDTO modifyUserDTO) {
		userMapper.modifyUserInfo(modifyUserDTO);
	}
}
