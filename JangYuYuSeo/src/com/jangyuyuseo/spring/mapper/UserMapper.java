package com.jangyuyuseo.spring.mapper;

import org.apache.ibatis.annotations.Insert;

import com.jangyuyuseo.spring.dto.UserDTO;

public interface UserMapper {
	@Insert("insert into user_table VALUES(user_seq.nextval, #{user_name}, #{user_id}, #{user_password}, #{user_address}, #{user_phone})")
	public void addUserInfo(UserDTO joinUserDTO);
}
