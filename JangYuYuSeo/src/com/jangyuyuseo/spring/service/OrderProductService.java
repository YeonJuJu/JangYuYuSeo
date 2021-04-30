package com.jangyuyuseo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jangyuyuseo.spring.dao.OrderProductDAO;
import com.jangyuyuseo.spring.dto.OrderProductDTO;

@Service
public class OrderProductService {
	@Autowired
	private OrderProductDAO orderProductDAO;
	
	public void addOrderProductDTO(OrderProductDTO orderProductDTO) {
		orderProductDAO.addOrderProductDTO(orderProductDTO);
	}
}
