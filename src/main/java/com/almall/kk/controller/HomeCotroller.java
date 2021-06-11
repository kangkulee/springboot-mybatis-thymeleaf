package com.almall.kk.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.almall.kk.mapper.ProductMapper;
import com.almall.kk.vo.ProductVO;

@Controller
public class HomeCotroller {
	
	@Autowired
	private ProductMapper productMapper;
	
	@GetMapping("/")
	public String index(Model model) {
		ArrayList<ProductVO> productList = productMapper.findByProducts();
		model.addAttribute("products", productList);
		model.addAttribute("size", productList.size());
		return "index";
	}
	
	@GetMapping("/auth/join")
	public String joinForm() {
		return "joinForm";
	}
	
	@GetMapping("/auth/login")
	public String loginForm() {
		return "loginForm";
	}
}
