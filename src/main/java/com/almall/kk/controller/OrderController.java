package com.almall.kk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.almall.kk.config.auth.PrincipalDetail;
import com.almall.kk.mapper.ProductMapper;
import com.almall.kk.mapper.UserMapper;
import com.almall.kk.vo.ProductVO;
import com.almall.kk.vo.UserVO;

@Controller
public class OrderController {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ProductMapper productMapper;
	
	@GetMapping("/auth/order/{productNo}")
	public String orderForm(@PathVariable int productNo, Model model, @AuthenticationPrincipal PrincipalDetail principal) {
		if(principal != null) {
			
			UserVO userVO = userMapper.findByName(principal.getUsername());
			model.addAttribute("user", userVO);
		}
		
		ProductVO productVO = productMapper.findByProductNo(productNo);
		model.addAttribute("product", productVO);
		
		return "orderForm";
	}
}
