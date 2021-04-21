package com.jangyuyuseo.spring.dto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Data;

@Data
public class ProductDTO {
	private int pr_id;
	@NotBlank
	private String pr_name;
	@NotBlank
	private String pr_description;
	@NotNull
	@PositiveOrZero
	private int pr_price;
	@NotBlank
	private String pr_size;
	@NotBlank
	private String pr_color;
	@NotBlank
	private String pr_detail;
	@NotNull
	@PositiveOrZero
	private int pr_stock;

	private int pr_sales;
	private String pr_date;
	private int pr_category;
	@NotBlank
	private String pr_image;
}
