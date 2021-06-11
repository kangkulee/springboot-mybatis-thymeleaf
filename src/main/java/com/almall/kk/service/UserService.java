package com.almall.kk.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almall.kk.mapper.UserMapper;
import com.almall.kk.vo.RoleType;
import com.almall.kk.vo.UserVO;

@Service
public class UserService {
	
	private final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private BCryptPasswordEncoder encode;
	
	
	@Transactional
	public int setUser(UserVO userVO) {
		userVO.setUser_password(encode.encode(userVO.getUser_password()));
		userVO.setUser_role(RoleType.USER);
		int result = userMapper.setUser(userVO);
		if (result > 0) {
			int userNo = userMapper.findUserNo(userVO.getUser_id());
			int roleNo = userMapper.findRoleNo(userVO.getUser_role());
			
			userMapper.setUserRole(userNo, roleNo);
			
			return 1;
		}
		return -1;
	}
}
