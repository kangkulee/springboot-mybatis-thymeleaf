package com.almall.kk.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.almall.kk.service.OrderService;
import com.almall.kk.vo.OrderVO;
import com.almall.kk.vo.ResponseVO;

@RestController
public class OrderApiController {
	
	@Autowired
	private OrderService orderService; 
	
	@PostMapping("/auth/orderProc")
	public ResponseVO<String, Integer> order(@RequestBody OrderVO orderVO) {
		int result = orderService.setOrder(orderVO);
		return new ResponseVO<String, Integer>(null, HttpStatus.OK, result);
	}
}
