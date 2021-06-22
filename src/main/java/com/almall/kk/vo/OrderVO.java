package com.almall.kk.vo;

import java.sql.Timestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class OrderVO extends PagingVO {
	private int order_no;
	private int user_no;
	private int product_no;
	private String product_name;
	private Timestamp order_date;
	private int order_quantity;
	private String order_totalPrice;
}
