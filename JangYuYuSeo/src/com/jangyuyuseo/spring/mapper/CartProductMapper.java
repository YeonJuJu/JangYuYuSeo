package com.jangyuyuseo.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jangyuyuseo.spring.dto.CartProductDTO;

public interface CartProductMapper {
	@Insert("INSERT INTO CART_PRODUCT_TABLE "
			+ "VALUES(cart_product_seq.nextval, #{cart_id}, #{pr_id}, "
			+ "#{pr_amount}, #{pr_color}, #{pr_size},#{pr_image},#{pr_name},#{pr_price})")
	public void addCartProduct(CartProductDTO cartProductDTO);
	//카트에 같은 상품이 있는지 찾는 용도
	@Select("Select * from cart_product_table where cart_id=#{cart_id} and pr_id=#{pr_id} and pr_color=#{pr_color} and pr_size=#{pr_size}")
	public CartProductDTO findCartProductDTO(@Param("cart_id")int cart_id, @Param("pr_id")int pr_id, @Param("pr_color")String pr_color,@Param("pr_size")String pr_size);
	@Update("update cart_product_table set pr_amount = #{amount} where cart_pr_id = #{cart_pr_id}")
	public void updateCartProductAmount(@Param("amount")int amount,@Param("cart_pr_id")int cart_pr_id);
	@Select("Select * from cart_product_table where cart_id=#{cart_id}")
	public List<CartProductDTO> findProductListByCartId(int cart_id);
	@Select("Select * from cart_product_table where cart_pr_id=#{cart_pr_id}")
	public CartProductDTO findProductByCartId(int cart_pr_id);
	
}
