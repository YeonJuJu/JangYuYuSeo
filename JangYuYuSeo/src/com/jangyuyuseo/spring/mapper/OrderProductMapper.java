package com.jangyuyuseo.spring.mapper;

import org.apache.ibatis.annotations.Insert;

import com.jangyuyuseo.spring.dto.OrderProductDTO;

public interface OrderProductMapper {
	@Insert("INSERT INTO order_product_table VALUES (order_product_seq.nextval, #{order_id}, #{pr_id}, #{pr_amount}, #{pr_color}, #{pr_size}, #{pr_total_price})")
	public void addOrderProductDTO(OrderProductDTO orderProductDTO);
}
