package com.jangyuyuseo.spring.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.jangyuyuseo.spring.dto.CartDTO;

public interface CartMapper {
	
	@Select("select * from cart_table where cart_user_idx=#{user_id}")
	public CartDTO findCartDTOByUserId(int user_id);
	
	@Insert("INSERT INTO CART_TABLE VALUES(cart_seq.nextval, #{user_id})")
	public void addCartDTO(int user_id);
}
