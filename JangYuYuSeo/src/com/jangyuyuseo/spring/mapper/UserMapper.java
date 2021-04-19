package com.jangyuyuseo.spring.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.jangyuyuseo.spring.dto.UserDTO;

public interface UserMapper {
	@Insert("INSERT INTO USER_TABLE VALUES(user_seq.nextval, #{user_name}, #{user_id}, #{user_password}, #{user_address}, #{user_phone})")
	public void addUserInfo(UserDTO joinUserDTO);

	@Select("SELECT USER_NAME FROM USER_TABLE WHERE USER_ID = #{user_id}")
	public String checkID(String user_id);
}
