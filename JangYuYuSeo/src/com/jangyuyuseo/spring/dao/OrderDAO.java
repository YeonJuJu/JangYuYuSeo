package com.jangyuyuseo.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jangyuyuseo.spring.dto.OrderDTO;
import com.jangyuyuseo.spring.mapper.OrderMapper;

@Repository
public class OrderDAO {
	@Autowired
	private OrderMapper orderMapper;
	
	public int getNextOrderIndex() {
		int order_id = orderMapper.getNextOrderIndex();
		return order_id;
	}
	
	public void addOrderDTO(OrderDTO orderDTO) {
		orderMapper.addOrderDTO(orderDTO);
	}
	
	public List<OrderDTO> getOrderListByUserIdx(int order_user_idx){
		return orderMapper.getOrderListByUserIdx(order_user_idx);
	}
}
