package com.jangyuyuseo.spring.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jangyuyuseo.spring.dto.UserDTO;

public interface UserMapper {
	@Insert("INSERT INTO USER_TABLE VALUES(user_seq.nextval, #{user_name}, #{user_id}, #{user_password}, #{user_address}, #{user_phone})")
	public void addUserInfo(UserDTO joinUserDTO);

	@Select("SELECT USER_NAME FROM USER_TABLE WHERE USER_ID = #{user_id}")
	public String checkID(String user_id);

	@Select("SELECT USER_IDX, USER_NAME FROM USER_TABLE WHERE USER_ID=#{user_id} AND USER_PASSWORD=#{user_password}")
	public UserDTO getLoginUser(UserDTO loginUserDTO);
	
	@Select("SELECT * FROM USER_TABLE WHERE USER_IDX=#{user_idx} AND USER_NAME=#{user_name} AND USER_PASSWORD=#{user_password}")
	public UserDTO getUserInfo(UserDTO checkUserDTO);
	
	@Update("UPDATE USER_TABLE SET USER_PASSWORD=#{user_password}, USER_NAME=#{user_name}, USER_ADDRESS=#{user_address}, USER_PHONE=#{user_phone} WHERE USER_IDX=#{user_idx}")
	public void modifyUserInfo(UserDTO modifyUserDTO);
}
