package com.jangyuyuseo.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.jangyuyuseo.spring.dto.OrderDTO;

public interface OrderMapper {
	@Select("SELECT ORDER_SEQ.NEXTVAL FROM DUAL")
	public int getNextOrderIndex();
	
	@Insert("INSERT INTO ORDER_TABLE VALUES(#{order_id}, #{order_user_idx}, #{order_name}, #{order_address}, #{order_phone}, #{order_message}, SYSDATE)")
	public void addOrderDTO(OrderDTO orderDTO);
	
	@Select("SELECT * FROM ORDER_TABLE WHERE ORDER_USER_IDX=#{order_user_idx} ORDER BY ORDER_DATE DESC")
	public List<OrderDTO> getOrderListByUserIdx(int order_user_idx);
	
	@Select("SELECT * FROM ORDER_TABLE ORDER BY ORDER_DATE DESC")
	public List<OrderDTO> getOrderList();
}
