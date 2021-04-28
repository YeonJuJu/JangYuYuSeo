package com.jangyuyuseo.spring.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.jangyuyuseo.spring.dto.OrderDTO;

public interface OrderMapper {
	@Select("SELECT ORDER_SEQ.NEXTVAL FROM DUAL")
	public int getNextOrderIndex();
	
	@Insert("INSERT INTO ORDER_TABLE VALUES(#{order_id}, #{order_user_idx}, #{order_name}, #{order_address}, #{order_phone}, #{order_message}, SYSDATE)")
	public void addOrderDTO(OrderDTO orderDTO);
}
