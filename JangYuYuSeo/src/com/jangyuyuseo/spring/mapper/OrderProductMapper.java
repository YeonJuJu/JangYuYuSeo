package com.jangyuyuseo.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.jangyuyuseo.spring.dto.OrderProductDTO;
import com.jangyuyuseo.spring.dto.ProductDTO;

public interface OrderProductMapper {
	@Insert("INSERT INTO order_product_table VALUES (order_product_seq.nextval, #{order_id}, #{pr_id}, #{pr_amount}, #{pr_color}, #{pr_size}, #{pr_total_price})")
	public void addOrderProductDTO(OrderProductDTO orderProductDTO);
	
	@Select("select order_pr_id,"
			+ "order_product_table.order_id,"
			+ "order_product_table.pr_id,"
			+ "order_product_table.pr_amount,"
			+ "order_product_table.pr_color,"
			+ "order_product_table.pr_size,"
			+ "order_product_table.pr_total_price,"
			+ "product_table.pr_name,"
			+ "product_table.pr_image "
			+ "from order_product_table, product_table "
			+ "where order_product_table.pr_id = product_table.pr_id")
	public List<OrderProductDTO> getAllOrderProductList();
	
	@Select("select order_pr_id,"
			+ "order_product_table.order_id,"
			+ "order_product_table.pr_id,"
			+ "order_product_table.pr_amount,"
			+ "order_product_table.pr_color,"
			+ "order_product_table.pr_size,"
			+ "order_product_table.pr_total_price,"
			+ "product_table.pr_name,"
			+ "product_table.pr_image "
			+ "from order_product_table, product_table "
			+ "where order_product_table.order_id=#{order_id} "
			+ "and order_product_table.pr_id = product_table.pr_id")
	public List<OrderProductDTO> getOrderProductListByOrderId(int order_id);
}
