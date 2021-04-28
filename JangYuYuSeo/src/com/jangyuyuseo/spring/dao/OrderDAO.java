package com.jangyuyuseo.spring.dao;

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
}
