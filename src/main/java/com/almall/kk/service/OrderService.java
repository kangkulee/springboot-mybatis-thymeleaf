package com.almall.kk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.almall.kk.mapper.OrderMapper;
import com.almall.kk.paging.PageHandler;
import com.almall.kk.vo.OrderVO;

@Service
public class OrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Transactional
	public int setOrder(OrderVO orderVO) {
		return orderMapper.setOrder(orderVO);
	}

	public void getOrderList(OrderVO orderVO, Model model) {
		int contentNum = 5;
		int limitCnt = ((orderVO.getPageNum() - 1) * contentNum);
		List<OrderVO> orderList = orderMapper.getOrderList(orderVO.getUser_no());
		int totalCnt = orderMapper.getOrderListTotalCnt(orderVO.getUser_no());
		orderVO.setLimitCnt(limitCnt);
		orderVO.setContentNum(contentNum);
		PageHandler pageHandler = PagingHandler(totalCnt, orderVO.getPageNum(), contentNum);
		model.addAttribute("size", totalCnt);
		model.addAttribute("pageHandler", pageHandler);
		model.addAttribute("orderList", orderList);
	}
	
	private PageHandler PagingHandler(int totalCount, int pageNum, int contentNum) {

		PageHandler pageHandler = new PageHandler();
		pageHandler.setTotalCnt(totalCount);
		pageHandler.setPageNum(pageNum);
		pageHandler.setContentNum(contentNum);
		pageHandler.setCurrentPage(pageNum);
		pageHandler.setLastPage(pageHandler.getTotalCnt());
		pageHandler.prevOrNext(pageNum);
		pageHandler.setStartPage(pageHandler.getCurrentPage());
		pageHandler.setEndPage(pageHandler.getLastPage(), pageHandler.getCurrentPage());

		return pageHandler;
	}
	
}
