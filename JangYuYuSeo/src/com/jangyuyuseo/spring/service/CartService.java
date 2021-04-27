package com.jangyuyuseo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jangyuyuseo.spring.dao.CartDAO;
import com.jangyuyuseo.spring.dao.CartProductDAO;
import com.jangyuyuseo.spring.dto.CartDTO;
import com.jangyuyuseo.spring.dto.CartProductDTO;

@Service
public class CartService {
	@Autowired
	CartDAO cartDAO;
	

	public void addCartDTO(int user_id) {
		cartDAO.addCartDTO(user_id);
	}
	
	public CartDTO findCartDTOByUserId(int user_id) {
		return cartDAO.findCartDTOByUserId(user_id);
	}

	
}
