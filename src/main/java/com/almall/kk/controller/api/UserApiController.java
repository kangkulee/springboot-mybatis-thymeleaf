package com.almall.kk.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.almall.kk.service.UserService;
import com.almall.kk.vo.ResponseVO;
import com.almall.kk.vo.UserVO;

@RestController
public class UserApiController {
	
	private final Logger logger = LoggerFactory.getLogger(UserApiController.class);

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/auth/joinProc")
	public ResponseVO<String, Integer> userJoin(@RequestBody UserVO userVO) {
		int result = userService.setUser(userVO);
		return new ResponseVO<String, Integer>(null, HttpStatus.OK, result);
	}
	
	@PutMapping("/api/user/{userNo}")
	public ResponseVO<String, Integer> updateUserDetail(@PathVariable("userNo") int userNo, @RequestBody UserVO userVO) {
		int result = userService.updateUserDetail(userNo, userVO);
		return new ResponseVO<String, Integer>(null, HttpStatus.OK, result);
	}
	
}
