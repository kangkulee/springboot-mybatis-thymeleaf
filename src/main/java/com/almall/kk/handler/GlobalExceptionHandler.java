package com.almall.kk.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.almall.kk.vo.ResponseVO;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=Exception.class)
	public ResponseVO<String, Integer> handlerArgumentException(Exception e) {
		return new ResponseVO<String, Integer>(e.getMessage(), HttpStatus.EXPECTATION_FAILED, -1);
	}
}
