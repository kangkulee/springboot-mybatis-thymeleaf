package com.almall.kk.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.almall.kk.vo.UserVO;
import com.almall.kk.vo.PrincipalVO;
import com.almall.kk.vo.ProductVO;
import com.almall.kk.vo.RoleType;



@Mapper
@Repository
public interface UserMapper {

	int setUser(UserVO userVO);

	ArrayList<PrincipalVO> findById(@Param("userId") String id);

	int findUserNo(@Param("userId") String user_id);

	int findRoleNo(@Param("roleName") RoleType user_role);

	int setUserRole(@Param("userNo") int userNo, @Param("roleNo") int roleNo);

	UserVO findByName(@Param("userId") String userId);

}
