package com.almall.kk.config.auth;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.almall.kk.mapper.UserMapper;
import com.almall.kk.vo.PrincipalVO;

@Service
public class PrincipalDetailService implements UserDetailsService{

	private Logger logger = LoggerFactory.getLogger(PrincipalDetailService.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// DB로 부터 회원정보 가져오기
		ArrayList<PrincipalVO> principal = userMapper.findById(username);
		
		if(principal.size() == 0) {
			throw new UsernameNotFoundException("User "+username+" Not Found!");
		}
		return new PrincipalDetail(principal);
	}

}
