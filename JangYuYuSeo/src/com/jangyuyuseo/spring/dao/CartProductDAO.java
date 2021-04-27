package com.jangyuyuseo.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jangyuyuseo.spring.dto.CartProductDTO;
import com.jangyuyuseo.spring.mapper.CartProductMapper;

@Repository
public class CartProductDAO {
	
	@Autowired
	private CartProductMapper cartProductMapper;
	
	public void addCartProduct(CartProductDTO cartProductDTO) {
		cartProductDTO.setPr_amount(1);
		cartProductMapper.addCartProduct(cartProductDTO);
	}
	public void updateCartProductAmount(int amount,int cart_pr_id) {
		cartProductMapper.updateCartProductAmount(amount,cart_pr_id);
	}
	public CartProductDTO findCartProductDTO(int cart_id, int pr_id, String pr_color, String pr_size) {
		return cartProductMapper.findCartProductDTO(cart_id, pr_id, pr_color,  pr_size);
	}
	public List<CartProductDTO> findProductListByCartId(int cart_id) {
		return cartProductMapper.findProductListByCartId(cart_id);
	}
	public CartProductDTO findProductByCartId(int cart_pr_id) {
		return cartProductMapper.findProductByCartId(cart_pr_id);
	}
}
