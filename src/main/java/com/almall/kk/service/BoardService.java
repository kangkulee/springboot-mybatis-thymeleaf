package com.almall.kk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.almall.kk.mapper.BoardMapper;
import com.almall.kk.paging.PageHandler;
import com.almall.kk.vo.FreeBoardVO;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Transactional
	public int writeBoard(FreeBoardVO freeBoardVO) {
		return boardMapper.writeBoard(freeBoardVO);
	}
	
	public void getFreeBoard(FreeBoardVO freeBoardVO, Model model) {
		int contentNum = 5;
		int limitCnt = ((freeBoardVO.getPageNum() - 1) * contentNum);
		int totalCnt = boardMapper.getFreeBoardTotalCnt(freeBoardVO);
		freeBoardVO.setLimitCnt(limitCnt);
		freeBoardVO.setContentNum(contentNum);
		List<FreeBoardVO> boardList = boardMapper.getFreeBoard(freeBoardVO);
		PageHandler pageHandler = PagingHandler(totalCnt, freeBoardVO.getPageNum(), contentNum);
		model.addAttribute("column", freeBoardVO.getColumn());
		model.addAttribute("search", freeBoardVO.getSearch());
		model.addAttribute("boardList", boardList);
		model.addAttribute("size", totalCnt);
		model.addAttribute("pageHandler", pageHandler);
		
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
	
	@Transactional
	public FreeBoardVO findByNo(int boardNo) {
		return boardMapper.findByNo(boardNo);
	}
	
	@Transactional
	public int updateBoard(int boardNo, FreeBoardVO freeBoardVO) {
		freeBoardVO.setFreeboard_no(boardNo);
		return boardMapper.updateBoard(freeBoardVO);
	}
	
	@Transactional
	public int deleteBoard(int boardNo) {
		return boardMapper.deleteBoard(boardNo);
	}
}
