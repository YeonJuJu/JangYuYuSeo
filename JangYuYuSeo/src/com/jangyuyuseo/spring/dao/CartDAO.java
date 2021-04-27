package com.jangyuyuseo.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jangyuyuseo.spring.dto.CartDTO;
import com.jangyuyuseo.spring.mapper.CartMapper;

@Repository
public class CartDAO {
	
	@Autowired
	private CartMapper cartMapper;
	
	public CartDTO findCartDTOByUserId(int user_id) {
		return cartMapper.findCartDTOByUserId(user_id);
	}

	public void addCartDTO(int user_id) {
		cartMapper.addCartDTO(user_id);
	}

}
