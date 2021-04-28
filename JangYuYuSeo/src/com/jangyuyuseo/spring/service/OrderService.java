package com.jangyuyuseo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jangyuyuseo.spring.dao.OrderDAO;
import com.jangyuyuseo.spring.dto.OrderDTO;

@Service
public class OrderService {
	@Autowired
	private OrderDAO orderDAO;
	
	public int getNextOrderIndex() {
		int order_id = orderDAO.getNextOrderIndex();
		return order_id;
	}
	
	public void addOrderDTO(OrderDTO orderDTO) {
		orderDAO.addOrderDTO(orderDTO);
	}
}
