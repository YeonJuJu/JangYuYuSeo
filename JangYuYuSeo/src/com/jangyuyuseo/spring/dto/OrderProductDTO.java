package com.jangyuyuseo.spring.dto;

import lombok.Data;

@Data
public class OrderProductDTO {
	private int order_pr_id;
	private int order_id;
	private int pr_id;
	private int pr_amount;
	private String pr_color;
	private String pr_size;
	private int pr_total_price;
	private String pr_name;
	private String pr_image;
}
