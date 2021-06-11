package com.almall.kk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almall.kk.mapper.OrderMapper;
import com.almall.kk.vo.OrderVO;

@Service
public class OrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	
	public int setOrder(OrderVO orderVO) {
		return orderMapper.setOrder(orderVO);
	}
	
}
