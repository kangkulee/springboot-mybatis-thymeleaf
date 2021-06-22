package com.almall.kk.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.almall.kk.service.BoardService;
import com.almall.kk.vo.FreeBoardVO;
import com.almall.kk.vo.ResponseVO;

@RestController
public class BoardApiController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/api/freeboard")
	public ResponseVO<String, Integer> writeBoard(@RequestBody FreeBoardVO freeBoardVO) {
		int result = boardService.writeBoard(freeBoardVO);
		return new ResponseVO<String, Integer>(null, HttpStatus.OK, result);
	}
	
	@PutMapping("api/freeboard/{boardNo}")
	public ResponseVO<String, Integer> updateBoard(@PathVariable("boardNo") int boardNo, @RequestBody FreeBoardVO freeBoardVO) {
		int result = boardService.updateBoard(boardNo,freeBoardVO);
		return new ResponseVO<String, Integer>(null, HttpStatus.OK, result);
	}
	
	@DeleteMapping("api/freeboard/{boardNo}")
	public ResponseVO<String, Integer> deleteBoard(@PathVariable("boardNo") int boardNo) {
		System.out.println("board_no" + boardNo);
		int result = boardService.deleteBoard(boardNo);
		return new ResponseVO<String, Integer>(null, HttpStatus.OK, result);
	}
}
