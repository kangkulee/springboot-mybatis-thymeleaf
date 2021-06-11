package com.almall.kk.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.almall.kk.vo.PrincipalVO;

public class PrincipalDetail implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<PrincipalVO> principalVO ;

	public PrincipalDetail(ArrayList<PrincipalVO> principal) {
		this.principalVO = principal;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		
		for(int i=0; i<principalVO.size(); i++) {
			collectors.add(new SimpleGrantedAuthority(principalVO.get(i).getUser_role().toString()));
		}
		return collectors;
	}

	@Override
	public String getPassword() {
		return principalVO.get(0).getUser_password();
	}

	@Override
	public String getUsername() {
		return principalVO.get(0).getUser_id();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
}
