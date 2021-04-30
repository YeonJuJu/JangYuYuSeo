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
		cartProductMapper.addCartProduct(cartProductDTO);
	}
	public void updateCartProductAmount(int amount,int cart_pr_id) {
		CartProductDTO cartProductDTO = cartProductMapper.findProductByCartPrId(cart_pr_id);
		cartProductDTO.setTotal_price(amount*cartProductDTO.getPr_price());
		cartProductMapper.updateCartProductAmount(amount,cart_pr_id);
	}
	public CartProductDTO findCartProductDTO(int cart_id, int pr_id, String pr_color, String pr_size) {
		return cartProductMapper.findCartProductDTO(cart_id, pr_id, pr_color,  pr_size);
	}
	public List<CartProductDTO> findProductListByCartId(int cart_id) {
		List<CartProductDTO> result = cartProductMapper.findProductListByCartId(cart_id);
		int len = result.size();
		for(int i=0;i<len;i++) 
			result.get(i).setTotal_price(result.get(i).getPr_amount()*result.get(i).getPr_price());
		return result;
	}
	public CartProductDTO findProductByCartPrId(int cart_pr_id) {
		CartProductDTO result = cartProductMapper.findProductByCartPrId(cart_pr_id);
		result.setTotal_price(result.getPr_amount()*result.getPr_price());
		return result;
	}
	public void deleteCartProduct(int cart_pr_id) {
		cartProductMapper.deleteCartProduct(cart_pr_id);
	}
	public void initCartCheckedFalse(int cart_id) {
		List<CartProductDTO> cartProductList = findProductListByCartId(cart_id);
		int len = cartProductList.size();
		for(int i=0;i<len;i++)
			cartProductMapper.initCartCheckedFalse(cartProductList.get(i).getCart_pr_id());
	}
	public void setCheckedTrue(int cart_pr_id) {
		cartProductMapper.setCheckedTrue(cart_pr_id);
	}
}
