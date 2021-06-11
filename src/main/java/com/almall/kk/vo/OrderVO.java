package com.almall.kk.vo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class OrderVO {
	private int user_no;
	private int product_no;
	private Timestamp order_date;
	private int order_quantity;
	private String order_totalPrice;
}
