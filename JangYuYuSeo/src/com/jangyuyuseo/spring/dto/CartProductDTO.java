package com.jangyuyuseo.spring.dto;

import lombok.Data;

@Data
public class CartProductDTO {
	private int cart_pr_id;
	private int cart_id;
	private int pr_id;
	private int pr_amount;
	private String pr_color;
	private String pr_size;
	private String pr_image;
	private String pr_name;
	private int pr_price;
}
