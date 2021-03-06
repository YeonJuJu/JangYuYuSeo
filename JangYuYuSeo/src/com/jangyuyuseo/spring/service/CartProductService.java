package com.jangyuyuseo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jangyuyuseo.spring.dao.CartProductDAO;
import com.jangyuyuseo.spring.dto.CartProductDTO;

@Service
public class CartProductService {
	@Autowired
	CartProductDAO cartProductDAO;

	public void updateCartProductAmount(int amount,int cartPrId) {
		cartProductDAO.updateCartProductAmount(amount,cartPrId);
	}
	
	public int addCartProduct(CartProductDTO cartProductDTO,int cartId) {
		//이미 장바구니에 담았는지 확인 
		CartProductDTO preCartProductDTO = cartProductDAO.findCartProductDTO(cartId, cartProductDTO.getPr_id(),cartProductDTO.getPr_color(),cartProductDTO.getPr_size());
		//없으면
		if(preCartProductDTO == null) {
			//새로추가 
			cartProductDTO.setPr_amount(1);
			cartProductDTO.setTotal_price(cartProductDTO.getPr_price());
			cartProductDAO.addCartProduct(cartProductDTO);
		}
		//있으면 수량 ++, checked true로 set
		else {
			cartProductDAO.updateCartProductAmount(preCartProductDTO.getPr_amount()+1,preCartProductDTO.getCart_pr_id());
			cartProductDAO.setCheckedTrue(preCartProductDTO.getCart_pr_id());
		}
		return cartProductDAO.findCartProductDTO(cartId, cartProductDTO.getPr_id(),cartProductDTO.getPr_color(),cartProductDTO.getPr_size()).getCart_pr_id();
	}
	
	public List<CartProductDTO> findProductListByCartId(int cart_id) {
		return cartProductDAO.findProductListByCartId(cart_id);
	}
	public CartProductDTO findProductByCartPrId(int cart_pr_id) {
		return cartProductDAO.findProductByCartPrId(cart_pr_id);
	}
	public void deleteCartProduct(int cart_pr_id) {
		cartProductDAO.deleteCartProduct(cart_pr_id);
	}
	//카트 안의 상품의 check를 false로 초기화하는 메소드
	public void initCartCheckedFalse(int cart_id) {
		cartProductDAO.initCartCheckedFalse(cart_id);
	}
	public void setCheckedTrue(int cart_pr_id) {
		cartProductDAO.setCheckedTrue(cart_pr_id);
	}
	
	public List<CartProductDTO> findProductListByCartIdWithChecked(int cart_id){
		return cartProductDAO.findProductListByCartIdWithChecked(cart_id);
	}
}
