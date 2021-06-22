package com.almall.kk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.almall.kk.config.auth.PrincipalDetail;
import com.almall.kk.mapper.UserMapper;
import com.almall.kk.service.BoardService;
import com.almall.kk.vo.FreeBoardVO;
import com.almall.kk.vo.UserVO;

@Controller
public class BoardController {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private BoardService boardService;

	@GetMapping("/auth/freeboard/{pageNum}")
	public String freeBoardForm(@PathVariable("pageNum") int pageNum, FreeBoardVO freeBoardVO, Model model, @AuthenticationPrincipal PrincipalDetail principal) {
		freeBoardVO.setPageNum(pageNum);
		boardService.getFreeBoard(freeBoardVO, model);
		model.addAttribute("principal", principal);
		return "freeBoard";
	}
	
	@GetMapping("/auth/freeboard/{pageNum}/{column}/{search}")
	public String freeBoardSearch(@PathVariable("pageNum") int pageNum, @PathVariable("column") String column, @PathVariable("search") String search, FreeBoardVO freeBoardVO, Model model) {
		freeBoardVO.setPageNum(pageNum);
		freeBoardVO.setColumn(column);
		freeBoardVO.setSearch(search);
		boardService.getFreeBoard(freeBoardVO, model);
		return "freeBoard";
	}

	@GetMapping("/auth/write")
	public String writeForm(Model model, @AuthenticationPrincipal PrincipalDetail principal) {
		
		if (principal != null) {

			UserVO userVO = userMapper.findByName(principal.getUsername());
			model.addAttribute("user", userVO);
		}
		return "writeForm";
	}
	
	@GetMapping("/board/{boardNo}")
	public String boardDetail(@PathVariable("boardNo") int boardNo, Model model) {
		FreeBoardVO freeBoardVO = boardService.findByNo(boardNo);
		model.addAttribute("board", freeBoardVO);
		return "boardDetail";
	}
	
	@GetMapping("/board/{boardNo}/boardform")
	public String updateBoardForm(@PathVariable("boardNo") int boardNo, Model model) {
		FreeBoardVO freeBoardVO = boardService.findByNo(boardNo);
		model.addAttribute("board", freeBoardVO);
		return "updateBoardForm";
	}
}
