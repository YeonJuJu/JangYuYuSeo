package com.jangyuyuseo.spring.service;

import java.util.List;

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
	
	public List<OrderDTO> getOrderListByUserIdx(int order_user_idx){
		return orderDAO.getOrderListByUserIdx(order_user_idx);
	}
	
	public List<OrderDTO> getOrderList() {
		return orderDAO.getOrderList();
	}
}
