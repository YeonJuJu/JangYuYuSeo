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
}
