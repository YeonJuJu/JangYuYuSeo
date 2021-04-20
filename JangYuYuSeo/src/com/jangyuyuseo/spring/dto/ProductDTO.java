package com.jangyuyuseo.spring.dto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import lombok.Data;

@Data
public class ProductDTO {
	private int pr_id;
	private String pr_name;
	private String pr_description;
	private int pr_price;
	private String pr_size;
	private String pr_color;
	private byte[] pr_image;
	private String pr_detail;
	private int pr_stock;
	private int pr_sales;
	private String pr_date;
	private int pr_category;

}
