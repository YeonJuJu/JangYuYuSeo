package com.jangyuyuseo.spring.dto;

import lombok.Data;

@Data
public class OrderDTO {
	private int order_id;
	private int order_user_idx;
	private String order_name;
	private String order_address;
	private String order_phone;
	private String order_message;
	private String order_date;
}
