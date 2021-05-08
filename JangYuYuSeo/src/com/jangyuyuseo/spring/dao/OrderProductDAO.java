package com.jangyuyuseo.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jangyuyuseo.spring.dto.OrderProductDTO;
import com.jangyuyuseo.spring.mapper.OrderProductMapper;

@Repository
public class OrderProductDAO {
	@Autowired
	private OrderProductMapper orderProductMapper;
	
	public void addOrderProductDTO(OrderProductDTO orderProductDTO) {
		orderProductMapper.addOrderProductDTO(orderProductDTO);
	}

	public List<OrderProductDTO> getAllOrderProductList() {
		return orderProductMapper.getAllOrderProductList();
	}
	
	public List<OrderProductDTO> getOrderProductListByOrderId(int order_id) {
		return orderProductMapper.getOrderProductListByOrderId(order_id);
	}
}
